package com.bci.users.infraestructure.h2database;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class PhoneJpa {
	
	
	public PhoneJpa() {
		
	}
	
	@Id
	private UUID id;
	
	
	//private UserJpa usuarios;
	
	//private UUID id_user;
	
	private String number;
	
	private String citycode;
	
	private String countrycode;

	public PhoneJpa(String number, String contrycode, String citycode) {
		
		this.id = UUID.randomUUID();
		this.number = number;
		this.countrycode = contrycode;
		this.citycode = citycode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

//	public UserJpa getUsuarios() {
//		return usuarios;
//	}
//
//	public void setUsuarios(UserJpa usuarios) {
//		this.usuarios = usuarios;
//	}

//	public UUID getId_user() {
//		return id_user;
//	}
//
//	public void setId_user(UUID id_user) {
//		this.id_user = id_user;
//	}
//	
	
	
	
}
