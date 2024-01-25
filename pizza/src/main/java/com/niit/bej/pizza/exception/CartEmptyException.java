package com.niit.bej.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Cart is Empty!", code= HttpStatus.CONFLICT)
public class CartEmptyException extends Throwable {
    public CartEmptyException(String message) {
        super(message);
    }
}
