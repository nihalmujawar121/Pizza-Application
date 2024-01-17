package com.niit.bej.pizza.order.repository;

import com.niit.bej.pizza.order.model.PizzaOrder;
import com.niit.bej.pizza.order.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, PizzaOrder> {
    Optional<User> findUserByUserName(String userName);
}
