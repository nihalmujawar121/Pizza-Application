package com.niit.bej.pizza.order.controller;

import com.niit.bej.pizza.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2")
public class UserController {

    @Autowired
    UserService userService;
}
