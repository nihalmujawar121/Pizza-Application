package com.niit.bej.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userEmailId;
    private String username;
    private String password;
    private String mobileNumber;
    private String address;
}
