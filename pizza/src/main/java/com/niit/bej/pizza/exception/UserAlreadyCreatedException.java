package com.niit.bej.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "User already exist!", code = HttpStatus.CONFLICT)
public class UserAlreadyCreatedException extends Exception {
    public UserAlreadyCreatedException(String message) {
        super(message);
    }
}
