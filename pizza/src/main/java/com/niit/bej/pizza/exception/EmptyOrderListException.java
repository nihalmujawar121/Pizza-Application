package com.niit.bej.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Order List is Empty!", code = HttpStatus.CONFLICT)
public class EmptyOrderListException extends Exception {
    public EmptyOrderListException(String message) {
        super(message);
    }
}
