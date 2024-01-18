package com.niit.bej.pizza.order.service;

import com.niit.bej.pizza.order.UserProxy.UserProxy;
import com.niit.bej.pizza.order.model.PizzaOrder;
import com.niit.bej.pizza.order.model.User;
import com.niit.bej.pizza.order.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    UserProxy userProxy;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public PizzaOrder addPizza(String username, PizzaOrder pizzaOrder) {
        return null;
    }

    @Override
    public PizzaOrder deletePizzaOrder(String username, String pizzaName) {
        return null;
    }

    @Override
    public List<PizzaOrder> viewCatalogue(String username) {
        return null;
    }

    @Override
    public List<PizzaOrder> getCarts(String username) {
        return null;
    }
}
