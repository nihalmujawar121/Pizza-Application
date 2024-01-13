package com.niit.bej.user.auth.service;

import com.niit.bej.user.auth.model.User;
import com.niit.bej.user.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public User login(User user) {
        return null;
    }
}
