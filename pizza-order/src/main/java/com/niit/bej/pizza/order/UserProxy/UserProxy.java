package com.niit.bej.pizza.order.UserProxy;

import com.niit.bej.pizza.order.model.User;
import com.niit.bej.pizza.order.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-auth", url = "https://localhost:8081")
public interface UserProxy {

    @PostMapping("api/v1/register")
    ResponseEntity<User> createUser(@RequestBody UserDTO user);
}
