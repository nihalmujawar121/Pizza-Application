package com.niit.bej.user.auth.service;

import com.niit.bej.user.auth.exception.InvalidCredentialsException;
import com.niit.bej.user.auth.exception.UserAlreadyRegisteredException;
import com.niit.bej.user.auth.exception.UserNotFoundException;
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
    public User register(User user) throws UserAlreadyRegisteredException {
        Optional<User> optionalUser = this.userRepository.findById(user.getUserId());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyRegisteredException("Customer name is taken, please choose another customer name");
        }
        return userRepository.save(user);
    }

    @Override
    public User login(User user) throws UserNotFoundException, InvalidCredentialsException {
        Optional<User> optionalUser = this.userRepository.findById(user.getUserId());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found !");
        }
        User userFromDatabase = optionalUser.get();
        if (userFromDatabase.getPassword().equals(user.getPassword())){
            return userFromDatabase;
        }
       throw new InvalidCredentialsException("Please check your username and password!");
    }
}


