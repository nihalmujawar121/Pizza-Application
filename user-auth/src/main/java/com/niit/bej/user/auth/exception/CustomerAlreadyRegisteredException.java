package com.niit.bej.user.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Customer already registered !", code = HttpStatus.CONFLICT)
public class CustomerAlreadyRegisteredException extends Exception {
    public CustomerAlreadyRegisteredException(String message) {
        super(message);
    }
}
