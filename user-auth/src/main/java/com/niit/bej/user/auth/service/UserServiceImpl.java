package com.niit.bej.user.auth.service;

import com.niit.bej.user.auth.exception.CustomerAlreadyRegisteredException;
import com.niit.bej.user.auth.model.User;
import com.niit.bej.user.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) throws CustomerAlreadyRegisteredException {
        Optional<User> optionalUser = this.userRepository.findById(user.getCustomerId());
        if (optionalUser.isPresent()) {
            throw new CustomerAlreadyRegisteredException("Customer name is taken, please choose another customer name");
        }
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        return null;
    }
}
