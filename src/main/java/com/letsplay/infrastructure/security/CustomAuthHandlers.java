package com.letsplay.infrastructure.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import static com.letsplay.application.exception.JsonResponseWriter.write;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthHandlers {

    public static class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(
                HttpServletRequest request,
                HttpServletResponse response,
                AuthenticationException authException
        ) throws IOException {
            write(
                    response,
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "UNAUTHORIZED",
                    "Authentication is required"
            );
        }
    }

    public static class JwtAccessDeniedHandler implements AccessDeniedHandler {

        @Override
        public void handle(
                HttpServletRequest request,
                HttpServletResponse response,
                AccessDeniedException accessDeniedException
        ) throws IOException {
            write(
                    response,
                    HttpServletResponse.SC_FORBIDDEN,
                    "FORBIDDEN",
                    "You do not have permission to access this resource"
            );
        }
    }
}
