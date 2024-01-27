package com.niit.bej.pizza.repository;

import com.niit.bej.pizza.model.PizzaOrder;
import com.niit.bej.pizza.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
//    Optional<User> findUserByUserEmailId(String userEmailId);
}
