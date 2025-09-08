package com.letsplay.domain.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.letsplay.application.dto.request.CreateUserCommand;
import com.letsplay.application.exception.EmailAlreadyExistsException;
import com.letsplay.domain.model.User;
import com.letsplay.domain.port.in.AuthService;
import com.letsplay.infrastructure.persistence.UserRepositoryImpl;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserRepositoryImpl userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public AuthServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(CreateUserCommand cmd) {
        if (existsByEmail(cmd.email())) {
            throw new EmailAlreadyExistsException(cmd.email());
        }

        String id = UUID.randomUUID().toString();

        User user = new User(
                id,
                cmd.name(),
                cmd.email(),
                encoder.encode(cmd.password()),
                cmd.role() != null ? cmd.role() : "USER",
                LocalDateTime.now()
        );

        userRepository.save(user);

        return user;
    }

    @Override
    public boolean existsByEmail(String email) {
        return !userRepository.findByEmail(email).isEmpty();
    }

}
