package com.niit.bej.pizza.service;

import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;

public interface UserService {
    User createUser(User user) throws UserAlreadyCreatedException;

    User addPizza(String userEmailId, PizzaOrder pizzaOrder);

    User deleteOrder(String userEmailId, String pizzaName);

}
