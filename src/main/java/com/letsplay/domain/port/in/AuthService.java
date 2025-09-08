package com.letsplay.domain.port.in;

import com.letsplay.application.dto.request.CreateUserCommand;
import com.letsplay.domain.model.User;

public interface AuthService {

    User register(CreateUserCommand command);

}
