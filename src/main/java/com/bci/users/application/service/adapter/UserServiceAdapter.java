package com.bci.users.application.service.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bci.users.application.service.port.UserServicePort;
import com.bci.users.domain.model.User;
import com.bci.users.domain.model.UserStatus;
import com.bci.users.domain.repository.UserPersistencePort;
import com.bci.users.infraestructure.h2database.UserJpa;
import com.bci.users.infraestructure.token.TokenGeneratorPort;

public class UserServiceAdapter implements UserServicePort {

	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceAdapter.class);
	
	private final UserPersistencePort userPersistencePort;
	
	private final TokenGeneratorPort tokenGeneratorPort;
	
	public UserServiceAdapter(final UserPersistencePort userPersistencePort,final TokenGeneratorPort tokenGeneratorPort) {
		this.userPersistencePort = userPersistencePort;
		this.tokenGeneratorPort = tokenGeneratorPort;
	}

	@Override
	public User saveUser(User user) {
		LOGGER.info("Save User");
		
		user.addToken(tokenGeneratorPort.getToken());	
		UserJpa us= userPersistencePort.findByEmail(user.getEmail());
		
		if(us != null) {
			user.validateExistUserWithMail(us.getEmail());
		}
		UserJpa jpaUser = new UserJpa(user);
		
		userPersistencePort.saveUser(jpaUser);
		
		UserStatus status = new UserStatus(jpaUser.getId(), jpaUser.getCreated(), jpaUser.getModified(), jpaUser.getLastLogin() , jpaUser.getActive());
		user.setUserStatus(status);
		
		return user;
		
		
	}

}
