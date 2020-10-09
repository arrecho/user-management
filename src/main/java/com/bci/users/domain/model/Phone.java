package com.bci.users.domain.model;

import javax.validation.constraints.Size;

public class Phone {

	
	private String number;
	
	@Size(min = 1, max = 3, message 
		      = "citycode between 1 and 3 characters")
	private String citycode;
	
	@Size(min = 1, max = 3, message 
		      = "citycode between 1 and 3 characters")
	private String contrycode;

	
	
	public Phone() {
		
	}
	
	public Phone(String number, String citycode, String contrycode) {
	
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}

	public String getNumber() {
		return number;
	}

	public String getCitycode() {
		return citycode;
	}

	public String getContrycode() {
		return contrycode;
	}
	
	
	
}
