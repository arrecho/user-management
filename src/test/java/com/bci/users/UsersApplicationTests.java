package com.bci.users;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bci.users.application.service.adapter.UserServiceAdapter;
import com.bci.users.application.service.port.UserServicePort;
import com.bci.users.domain.model.Phone;
import com.bci.users.domain.model.User;
import com.bci.users.domain.repository.UserPersistencePort;
import com.bci.users.infraestructure.h2database.UserJpa;
import com.bci.users.infraestructure.token.TokenGeneratorPort;

@SpringBootTest
class UsersApplicationTests {

	@Autowired
	private  UserPersistencePort userPersistencePort;
	
	@Autowired
	private  TokenGeneratorPort tokenGeneratorPort;
	
	private UserServicePort userServicePort;
	
	@Test
	void testSaveUser() {
		
		//Given
		Phone ph = new Phone("12345678", "1", "57");
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(ph);
		User user = new User("Christian", "christianchristian.com", "Password12", phones);
		this.userServicePort = new UserServiceAdapter(userPersistencePort,tokenGeneratorPort);

		//When	
		User userStatus = this.userServicePort.saveUser(user);
		boolean status = userStatus != null;
		
		//Then
		assertTrue(status);
		
		
	}
	
	@Test
	void testMailExist() {
		
		//Given
		
		String mail ="test@test.com";
		
		//When
		UserJpa  userWithMail = userPersistencePort.findByEmail(mail);
				
		
		//Then
		assertEquals(mail, userWithMail.getEmail());
		
		
	}
	

	

	
}
