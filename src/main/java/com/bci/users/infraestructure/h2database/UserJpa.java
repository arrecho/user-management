package com.bci.users.infraestructure.h2database;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bci.users.domain.model.Phone;
import com.bci.users.domain.model.User;

@Entity
@Table(name = "usuarios")
public class UserJpa {

	@Id
	private UUID id;
	private String name;
	private String email;
	private String password;
	private Date created;
	private LocalDateTime modified;
	@Column(name="LASTLOGIN")
	//Java 8 implementation
	private Date lastLogin;
	private String active;
	private String token;
	
	 @OneToMany(
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
	 @JoinColumn(name = "id_user")
	private List<PhoneJpa> phones;
	
	public UserJpa() {
		
		
	}
	
	public UserJpa(User user) {
		this.id = UUID.randomUUID();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.created = new Date();
		this.modified = (LocalDateTime.now());
		this.lastLogin = new Date();
		this.active = "1";
		this.token = user.getToken();
		addPhones(user);
	}

	private void addPhones(User user) {
		
		List<PhoneJpa> phoneEntList = new ArrayList<PhoneJpa>();	
		
		for(Phone phones : user.getPhones()) {
			
			phoneEntList.add(new PhoneJpa(phones.getNumber(), phones.getContrycode(), phones.getCitycode()));
		}
		
		this.phones = phoneEntList;
	}
	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<PhoneJpa> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneJpa> phones) {
		this.phones = phones;
	}
	
	
	
	
	
}
