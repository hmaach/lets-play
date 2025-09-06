package com.letsplay.domain.model;

import java.time.LocalDateTime;

public class User {

    private final String id;
    private String name;
    private String email;
    private final String password;
    private int age;
    private final String role;
    private final LocalDateTime createdAt;

    public User(String id, String name, String email, String password, int age, String role, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.role = role;
        this.createdAt = createdAt;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Domain actions
    public void changeName(String name) {
        this.name = name;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void changeAge(int age) {
        this.age = age;
    }
}
