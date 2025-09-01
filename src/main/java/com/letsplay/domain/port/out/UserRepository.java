package com.letsplay.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.letsplay.domain.model.User;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByUsername(String username);

    List<User> findAll();

    void deleteById(String id);
}
