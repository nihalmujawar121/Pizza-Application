package com.niit.bej.pizza.controller;

import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;
import com.niit.bej.pizza.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addPizza")
    public ResponseEntity<?> addPizza(HttpServletRequest httpServletRequest, @RequestBody PizzaOrder pizzaOrder) {
        String email = (String) httpServletRequest.getAttribute("userEmailId");
        System.out.println(email);
        if (email != null) {
            return new ResponseEntity<>(userService.addPizza(email, pizzaOrder), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error Occurred", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteOrder/{pizzaName}")
    public ResponseEntity<?> deletePizzaOrder(HttpServletRequest httpServletRequest, @PathVariable String pizzaName){
        String email = (String) httpServletRequest.getAttribute("userEmailId");
        System.out.println(email);
        if(email != null){
            return new ResponseEntity<>(userService.deleteOrder(email,pizzaName),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Error occurred",HttpStatus.NOT_FOUND);
        }
    }

}
