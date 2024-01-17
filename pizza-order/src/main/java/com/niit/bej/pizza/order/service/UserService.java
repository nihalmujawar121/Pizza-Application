package com.niit.bej.pizza.order.service;

import com.niit.bej.pizza.order.model.PizzaOrder;
import com.niit.bej.pizza.order.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    User findUserByUsername(String username);

    PizzaOrder addPizza(String username, PizzaOrder pizzaOrder);

    PizzaOrder deletePizzaOrder(String username, String pizzaName);

    List<PizzaOrder> viewCatalogue(String username);

    List<PizzaOrder> getCarts(String username);

}
