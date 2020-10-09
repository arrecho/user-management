package com.bci.users.infraestructure.h2database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bci.users.domain.repository.UserPersistencePort;

@Component
public class JpaUserServiceAdapter implements UserPersistencePort {

	private final static Logger LOGGER = LoggerFactory.getLogger(JpaUserServiceAdapter.class);
	
	@Autowired
	private JpaRepositoryPort h2UserRepository;
	
	
	
	@Override
	public void saveUser(UserJpa user) {
		LOGGER.info("Save User");
		h2UserRepository.save(user);	
	}



	@Override
	public UserJpa findByEmail(String mail) {
		LOGGER.info("Find mail");
		return h2UserRepository.findByEmail(mail);
		
	}

	
	
}
