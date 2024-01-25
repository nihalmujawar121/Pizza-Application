package com.niit.bej.pizza.service;

import com.niit.bej.pizza.exception.CartEmptyException;
import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.exception.UserNotFoundException;
import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;
import com.niit.bej.pizza.model.UserDTO;
import com.niit.bej.pizza.proxy.UserProxy;
import com.niit.bej.pizza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserProxy userProxy;

    @Override
    public User createUser(User user) throws UserAlreadyCreatedException {
        Optional<User> optionalUser = userRepository.findById(user.getUsername());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyCreatedException("User already exist!");
        }
        ResponseEntity details = userProxy.registerUser(new UserDTO(user.getUserEmailId(), user.getUsername(), user.getPassword(), user.getMobileNumber(), user.getAddress()));
        System.out.println(details.getBody());
        return userRepository.save(user);
    }

    @Override
    public PizzaOrder addPizza(String userEmailId, PizzaOrder pizzaOrder) throws UserNotFoundException, CartEmptyException {
        User userFromDatabase = getUserFromDatabase(userEmailId);
        List<PizzaOrder> cart = userFromDatabase.getCart();
        if (cart.isEmpty()) {
            throw new CartEmptyException("Cart is Empty!");
        }
        cart.add(pizzaOrder);
        userRepository.save(userFromDatabase);
        return pizzaOrder;
    }

    @Override
    public User deleteOrder(String userEmailId, String pizzaName) {
        return null;
    }

    private User getUserFromDatabase(String userEmailId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByUserEmailId(userEmailId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(userEmailId + " not found!");
        }
        return optionalUser.get();
    }


}

