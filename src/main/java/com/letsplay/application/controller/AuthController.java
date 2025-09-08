package com.letsplay.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.letsplay.application.dto.request.CreateUserCommand;
import com.letsplay.domain.model.User;
import com.letsplay.domain.service.AuthServiceImpl;

import jakarta.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private final AuthServiceImpl service;

    public AuthController(AuthServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/api/auth/register")
    public User register(@RequestBody @Valid CreateUserCommand command) {
        return service.register(command);
    }
}
