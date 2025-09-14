package com.letsplay.application.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsplay.application.dto.request.UpdateUserCommand;
import com.letsplay.application.dto.response.UserResponse;
import com.letsplay.domain.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/me")
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public UserResponse getUser(Authentication authentication) {
        String email = authentication.getName();
        return UserResponse.fromDomain(service.findByEmail(email));
    }

    @PatchMapping
    public UserResponse updateUser(Authentication authentication, @Valid @RequestBody UpdateUserCommand cmd) {
        String email = authentication.getName();
        return UserResponse.fromDomain(service.updateByEmail(email, cmd));
    }

    @DeleteMapping
    public void deleteUser(Authentication authentication) {
        String email = authentication.getName();
        service.deleteByEmail(email);
    }
}
