package com.bci.users.infraestructure.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.users.application.service.port.UserServicePort;
import com.bci.users.domain.model.User;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	
	private final UserServicePort userServicePort;
	
	@Autowired
	public UserController(UserServicePort userServicePort) {
		this.userServicePort = userServicePort;
	}

	@PostMapping(value = "/users/", produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> createUser(@Valid @RequestBody final User user){
		
		userServicePort.saveUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	
	
	

}
