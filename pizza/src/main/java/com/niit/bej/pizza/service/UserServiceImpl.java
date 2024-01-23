package com.niit.bej.pizza.service;

import com.niit.bej.pizza.model.User;
import com.niit.bej.pizza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return null;
    }
}
