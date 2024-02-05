package com.niit.bej.pizza.service;

import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user) throws UserAlreadyCreatedException;

    User addPizza(String userEmailId, PizzaOrder pizzaOrder);

    User deleteOrder(String userEmailId, String pizzaName);

    List<PizzaOrder> viewCatalogue();

    List<PizzaOrder> getCart(String emailId);

    User updatePizzaOrder(String userEmailId, String varietyOfPizza, PizzaOrder pizzaOrder);

}
