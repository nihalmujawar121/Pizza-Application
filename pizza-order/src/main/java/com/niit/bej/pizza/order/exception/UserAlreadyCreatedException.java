package com.niit.bej.pizza.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "user already created!", code = HttpStatus.CREATED)
public class UserAlreadyCreatedException extends Exception {
    public UserAlreadyCreatedException(String message) {
        super(message);
    }
}
