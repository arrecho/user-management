package com.bci.users.domain.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.bci.users.domain.model.exception.UserException;


public class User {
	
	private static final  String ERROR_MAIL_EXIST = "El correo ya registrado.";
	
	public User() {
		
	}
	
	private String name;
	
	@Email(message = "(email) wrong email format")
	private String email;
	
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,}[0-9]{2}",
    message = "(password) Only One uppercase,lowercase letters and two numbers")
	private String password;
	
	private List<Phone> phones;

	private String token;
	
	private UserStatus userStatus;
	
	public void  validateExistUserWithMail(String mail) {
		if(mail != null) {
		
			throw new UserException(ERROR_MAIL_EXIST);
		}
		
	}
	
	public User(String name,  String email,
			 String password,
			List<Phone> phones) {
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public String getToken() {
		return token;
	}
	
	public void addToken(String token) {
		
		this.token = token;
		
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	
	
	
	
}
