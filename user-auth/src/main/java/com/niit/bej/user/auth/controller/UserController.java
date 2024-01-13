package com.niit.bej.user.auth.controller;

import com.niit.bej.user.auth.exception.UserAlreadyRegisteredException;
import com.niit.bej.user.auth.model.User;
import com.niit.bej.user.auth.service.UserService;
import com.niit.bej.user.auth.service.security.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UserController {

    private final UserService userService;
    private final SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws UserAlreadyRegisteredException {
        User registerUser = userService.register(user);
        return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }
}
