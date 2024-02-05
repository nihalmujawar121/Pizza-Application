package com.niit.bej.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Pizza order not found!", code = HttpStatus.NOT_FOUND)
public class PizzaOrderNotFoundException extends Exception {
    public PizzaOrderNotFoundException(String message) {
        super(message);
    }
}
