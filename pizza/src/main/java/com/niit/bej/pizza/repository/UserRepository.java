package com.niit.bej.pizza.repository;

import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, PizzaOrder> {
}
