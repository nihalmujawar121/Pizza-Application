package com.niit.bej.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
    List<PizzaOrder> cart;
    @MongoId
    private String userEmailId;
    private String username;
    private String password;
    private String mobileNumber;
    private String address;
}
