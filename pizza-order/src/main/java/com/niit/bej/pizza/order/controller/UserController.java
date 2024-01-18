package com.niit.bej.pizza.order.controller;

import com.niit.bej.pizza.order.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.order.model.User;
import com.niit.bej.pizza.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveDetails")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyCreatedException {
        User details = userService.createUser(user);
        if (details != null) {
            return new ResponseEntity<>(details, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error Occurred", HttpStatus.NOT_FOUND);
        }
    }
}
