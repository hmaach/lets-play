package com.letsplay.application.dto.request;

public record CreateUserCommand(
    String username,
    String email,
    String password
) {}
