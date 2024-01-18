package com.niit.bej.pizza.order.service;

import com.niit.bej.pizza.order.UserProxy.UserProxy;
import com.niit.bej.pizza.order.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.order.model.PizzaOrder;
import com.niit.bej.pizza.order.model.User;
import com.niit.bej.pizza.order.model.UserDTO;
import com.niit.bej.pizza.order.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
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
    public User createUser(User user) throws UserAlreadyCreatedException {
        List<PizzaOrder> order = new ArrayList<>();
        user.setCart(order);
        ResponseEntity details = userProxy.createUser(new UserDTO(user.getUserEmailId(), user.getUsername(), user.getPassword(), user.getMobileNumber(), user.getAddress()));
        System.out.println(details.getBody());
        return userRepository.save(user);

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
