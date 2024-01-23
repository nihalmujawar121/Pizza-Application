package com.niit.bej.pizza.controller;

import com.niit.bej.pizza.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/pizza")
public class UserController {

    @Autowired
    UserService userService;
}
