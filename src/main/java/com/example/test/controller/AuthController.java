package com.example.test.controller;

import com.example.test.exeption.CustomException;
import com.example.test.model.AuthRequest;
import com.example.test.model.AuthResponse;
import com.example.test.model.ErrorResponse;
import com.example.test.model.UserCreate;
import com.example.test.service.auth.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_XML_VALUE)
    public Object authResponse(@RequestBody AuthRequest authUser) {
        try {
            return new AuthResponse(authService.signin(authUser.getUsername(), authUser.getPassword()));
        } catch (CustomException e) {
            return new ErrorResponse(e.getHttpStatus().toString(), e.getMessage());
        }
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_XML_VALUE)
    public Object signup(@RequestBody UserCreate user) {
        try {
            return new AuthResponse(authService.signup(user));
        } catch (CustomException e) {
            return new ErrorResponse(e.getHttpStatus().toString(), e.getMessage());
        }
    }
}
