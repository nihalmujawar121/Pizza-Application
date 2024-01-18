package com.niit.bej.pizza.order.UserProxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-auth", url="https://localhost:8081")
public interface UserProxy {
}
