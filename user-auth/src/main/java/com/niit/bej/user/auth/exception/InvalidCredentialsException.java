package com.niit.bej.user.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Invalid credentials", code = HttpStatus.CONFLICT)
public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
    }
}
