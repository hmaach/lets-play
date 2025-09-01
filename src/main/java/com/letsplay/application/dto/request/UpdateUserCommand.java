package com.letsplay.application.dto.request;

import java.util.Optional;

public class UpdateUserCommand {

    private Optional<String> username = Optional.empty();
    private Optional<String> email = Optional.empty();
    private Optional<String> password = Optional.empty();

    public UpdateUserCommand(Optional<String> username, Optional<String> email, Optional<String> password) {
        this.username = username != null ? username : Optional.empty();
        this.email = email != null ? email : Optional.empty();
        this.password = password != null ? password : Optional.empty();
    }

    public Optional<String> getUsername() {
        return username;
    }

    public void setUsername(Optional<String> username) {
        this.username = username != null ? username : Optional.empty();
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email != null ? email : Optional.empty();
    }

    public Optional<String> getPassword() {
        return password;
    }

    public void setPassword(Optional<String> password) {
        this.password = password != null ? password : Optional.empty();
    }
}
