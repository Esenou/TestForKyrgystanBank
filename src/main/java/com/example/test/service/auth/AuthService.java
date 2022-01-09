package com.example.test.service.auth;

import com.example.test.model.UserCreate;

public interface AuthService {

    String signin(String username, String password);

    String refresh(String username);

    String signup(UserCreate user);
}
