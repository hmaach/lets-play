package com.letsplay.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.letsplay.application.dto.request.CreateUserCommand;
import com.letsplay.application.dto.request.UpdateUserCommand;
import com.letsplay.application.dto.response.UserResponse;
import com.letsplay.domain.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/api/admin/users")
    public List<UserResponse> getUsers() {
        return service.findAll().stream()
                .map(UserResponse::fromDomain)
                .toList();
    }

    @PostMapping("/api/admin/users")
    public UserResponse createUser(@RequestBody @Valid CreateUserCommand cmd) {
        return UserResponse.fromDomain(
                service.createUser(cmd)
        );
    }

    @PutMapping("/api/admin/users/{id}")
    public UserResponse updateUser(@PathVariable String id, @Valid @RequestBody UpdateUserCommand cmd) {
        return UserResponse.fromDomain(
                service.updateUser(id, cmd)
        );
    }

    @DeleteMapping("/api/admin/users/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteUser(id);
    }
}
