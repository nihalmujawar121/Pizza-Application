package com.niit.bej.user.auth.service;

import com.niit.bej.user.auth.model.User;

public interface UserService {
    User register(User user);

    User login(User user);
}
