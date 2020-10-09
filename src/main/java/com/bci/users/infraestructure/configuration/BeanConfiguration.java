package com.bci.users.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bci.users.application.service.adapter.UserServiceAdapter;
import com.bci.users.application.service.port.UserServicePort;
import com.bci.users.domain.repository.UserPersistencePort;
import com.bci.users.infraestructure.token.TokenGeneratorPort;

@Configuration
@ComponentScan("com.bci.users")
public class BeanConfiguration {

	@Bean
	UserServicePort userService(final UserPersistencePort userPersistencePort,final TokenGeneratorPort tokenGeneratorPort) {
		return new UserServiceAdapter(userPersistencePort,tokenGeneratorPort);
	}
}
