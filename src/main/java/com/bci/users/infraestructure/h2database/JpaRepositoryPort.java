package com.bci.users.infraestructure.h2database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JpaRepositoryPort extends JpaRepository<UserJpa, String>{
	
	@Override
	<S extends UserJpa> S save (S entity);
	
	UserJpa findByEmail(String email);
	


}
