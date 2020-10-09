package com.bci.users

import spock.lang.Specification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import com.bci.users.domain.model.User

import com.bci.users.application.service.adapter.UserServiceAdapter
import com.bci.users.application.service.port.UserServicePort
import com.bci.users.domain.model.Phone
import com.bci.users.domain.repository.UserPersistencePort
import com.bci.users.infraestructure.token.TokenGeneratorPort


@SpringBootTest
class UsersApplicationTest extends Specification {
	
	
	@Autowired
	private  UserPersistencePort userPersistencePort;
	
	@Autowired
	private  TokenGeneratorPort tokenGeneratorPort;
	
	private UserServicePort userServicePort;
	
	
	
	void 'Integration Test new User'() {            
		given: 'A User with Valid Phones'                    
		
		Phone ph = new Phone("12345678", "1", "57");
		List<Phone> phones = new ArrayList<Phone>()
		phones.add(ph)
		
		User user = new User("Christian", "christian@christian.com", "Password12", phones);
		userServicePort = new UserServiceAdapter(userPersistencePort,tokenGeneratorPort)
			
		when: 'Save Values in BD Memory'                          
		User userResult = userServicePort.saveUser(user)
		
			
		then: 'Success Save?'              
			userResult.getUserStatus().getId() != null
	}

	
	
	
}
