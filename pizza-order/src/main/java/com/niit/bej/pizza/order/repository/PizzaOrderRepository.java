package com.niit.bej.pizza.order.repository;

import com.niit.bej.pizza.order.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaOrderRepository extends MongoRepository<User, Integer> {
}
