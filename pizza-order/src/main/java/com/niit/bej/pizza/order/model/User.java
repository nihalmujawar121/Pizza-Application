package com.niit.bej.pizza.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
    @MongoId
    private String userEmailId;
    private String userName;
    private String password;
    private String mobileNumber;
    private String address;
}
