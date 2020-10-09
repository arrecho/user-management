package com.bci.users.application.service.port;

import com.bci.users.domain.model.User;

public interface UserServicePort {

	User saveUser(User user);
}
