package com.niit.bej.pizza.controller;

import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.model.User;
import com.niit.bej.pizza.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/pizza")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User newUser = userService.createUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (UserAlreadyCreatedException exception) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
