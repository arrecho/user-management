package com.bci.users.domain.repository;

import com.bci.users.infraestructure.h2database.UserJpa;

public interface UserPersistencePort {

	
	void saveUser(UserJpa user);
	
	UserJpa findByEmail(String mail);
}
