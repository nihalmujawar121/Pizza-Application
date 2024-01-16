package com.niit.bej.user.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String userEmailId;
    private String userName;
    private String password;
    private String mobileNumber;
    private String address;

}
