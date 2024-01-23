package com.niit.bej.pizza.service;

import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.model.User;
import com.niit.bej.pizza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User user) throws UserAlreadyCreatedException {
        Optional<User> optionalUser = userRepository.findUserByUsername(user.getUsername());
        if(optionalUser.isPresent()){
            throw new UserAlreadyCreatedException("User already exist!");
        }
        return this.userRepository.save(user);
    }
}
