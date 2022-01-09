package com.example.test.service.auth.impl;

import com.example.test.entity.User;
import com.example.test.exeption.CustomException;
import com.example.test.model.UserCreate;
import com.example.test.repository.UserRepository;
import com.example.test.secutity.JwtTokenProvider;
import com.example.test.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String signin(String username, String password) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username);
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public String refresh(String username) {
        return jwtTokenProvider.createToken(username);
    }

    @Override
    public String signup(UserCreate userModel) {
        if (!userRepository.existsByUserName(userModel.getUsername())) {
            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
            User user = new User();
            user.setUserName(userModel.getUsername());
            user.setPassword(userModel.getPassword());
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUserName());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
