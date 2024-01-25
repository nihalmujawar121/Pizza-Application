package com.niit.bej.pizza.service;

import com.niit.bej.pizza.exception.CartEmptyException;
import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.exception.UserNotFoundException;
import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;

public interface UserService {
    User createUser(User user) throws UserAlreadyCreatedException;

    PizzaOrder addPizza(String userEmailId, PizzaOrder pizzaOrder) throws UserNotFoundException, CartEmptyException;

    User deleteOrder(String userEmailId, String pizzaName);

}
