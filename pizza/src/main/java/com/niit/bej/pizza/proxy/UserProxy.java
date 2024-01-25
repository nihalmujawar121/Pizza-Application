package com.niit.bej.pizza.proxy;

import com.niit.bej.pizza.model.User;
import com.niit.bej.pizza.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "UserAuth",url = "http://localhost:8081")
public interface UserProxy {

    @PostMapping("/home/register")
    ResponseEntity<User> registerUser(@RequestBody UserDTO user);
}
