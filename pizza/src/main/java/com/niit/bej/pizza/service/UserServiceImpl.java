package com.niit.bej.pizza.service;

import com.niit.bej.pizza.exception.UserAlreadyCreatedException;
import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;
import com.niit.bej.pizza.model.UserDTO;
import com.niit.bej.pizza.proxy.UserProxy;
import com.niit.bej.pizza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<PizzaOrder> order = new ArrayList<>();
        user.setCart(order);
        Optional<User> optionalUser = userRepository.findById(user.getUsername());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyCreatedException("User already exist!");
        }
        ResponseEntity<User> details = userProxy.registerUser(new UserDTO(user.getUserEmailId(), user.getUsername(), user.getPassword(), user.getMobileNumber(), user.getAddress()));
        System.out.println(details.getBody());
        return userRepository.save(user);
    }

    @Override
    public User addPizza(String userEmailId, PizzaOrder pizzaOrder) {
        User details = userRepository.findById(userEmailId).get();
        List<PizzaOrder> pizza = details.getCart();
        pizza.add(pizzaOrder);
        details.setCart(pizza);
        return userRepository.save(details);
    }

    @Override
    public User deleteOrder(String userEmailId, String pizzaName) {
        User details = userRepository.findById(userEmailId).get();
        List<PizzaOrder> cart = details.getCart();
        PizzaOrder removePizza = cart.stream().filter(pizza -> pizza.getVarietyOfPizza().equals(pizzaName)).toList().get(0);
        cart.remove(removePizza);
        details.setCart(cart);
        return userRepository.save(details);
    }

    @Override
    public List<PizzaOrder> viewCatalogue() {
        String admin = "Admin@gmail.com";
        User user = userRepository.findById(admin).get();
        List<PizzaOrder> pizzaOrderList = user.getCart();
        return pizzaOrderList;
    }

    @Override
    public List<PizzaOrder> getCart(String emailId) {
        User user = userRepository.findById(emailId).get();
        List<PizzaOrder> pizzaOrderList = user.getCart();
        return pizzaOrderList;
    }

    @Override
    public User updatePizzaOrder(String userEmailId, String varietyOfPizza, PizzaOrder pizzaOrder) {
        return null;
    }


}

