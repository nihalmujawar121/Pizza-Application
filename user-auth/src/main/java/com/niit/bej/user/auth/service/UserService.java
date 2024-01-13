package com.niit.bej.user.auth.service;

import com.niit.bej.user.auth.exception.CustomerAlreadyRegisteredException;
import com.niit.bej.user.auth.model.User;

public interface UserService {
    User register(User user) throws CustomerAlreadyRegisteredException;

    User login(User user);
}
