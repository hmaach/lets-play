package com.letsplay.domain.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User {

    private final String id;
    private String username;
    private String email;
    private final String password;
    private final Set<Role> roles;
    private final LocalDateTime createdAt;

    public User(String id, String username, String email, String password, Set<Role> roles, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = new HashSet<>(roles);
        this.createdAt = createdAt;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    // Domain actions
    public void changeUsername(String username) {
        this.username = username;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }
}
