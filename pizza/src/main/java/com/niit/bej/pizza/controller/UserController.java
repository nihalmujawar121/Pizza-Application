package com.niit.bej.pizza.controller;

import com.niit.bej.pizza.exception.CartEmptyException;
import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.exception.UserNotFoundException;
import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;
import com.niit.bej.pizza.service.UserService;
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

    @PostMapping("/{userEmailId}/cart/add")
    public ResponseEntity<PizzaOrder> addToCart(@PathVariable String userEmailId, @RequestBody PizzaOrder pizzaOrder){
        try{
            PizzaOrder addPizza = userService.addPizza(userEmailId,pizzaOrder);
            return new ResponseEntity<>(addPizza,HttpStatus.CREATED);
        }catch (UserNotFoundException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (CartEmptyException exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
