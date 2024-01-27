package com.niit.bej.user.auth.service;

import com.niit.bej.user.auth.exception.InvalidCredentialsException;
import com.niit.bej.user.auth.exception.UserAlreadyRegisteredException;
import com.niit.bej.user.auth.exception.UserNotFoundException;
import com.niit.bej.user.auth.model.User;
import com.niit.bej.user.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) throws UserAlreadyRegisteredException {
        Optional<User> optionalUser = this.userRepository.findById(user.getUserEmailId());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyRegisteredException("User email is taken, please choose another Email ID");
        }
        return userRepository.save(user);
    }

    @Override
    public User login(User user) throws UserNotFoundException, InvalidCredentialsException {
        Optional<User> optionalUser = userRepository.findById(user.getUserEmailId());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found !");
        }
        User newUser = optionalUser.get();
        if (user.getUserEmailId().equals(newUser.getUserEmailId()) && user.getPassword().equals(newUser.getPassword())) {
            return newUser;
        }
        throw new InvalidCredentialsException("Please check your username and password!");
    }
}


