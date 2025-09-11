package com.letsplay.application.dto.response;

import java.time.LocalDateTime;

import com.letsplay.domain.model.Product;

public record ProductResponse(
        String id,
        String name,
        String description,
        Double price,
        String userId,
        LocalDateTime createdAt
        ) {

    public static ProductResponse fromDomain(Product user) {
        return new ProductResponse(
                user.getId(),
                user.getName(),
                user.getDescription(),
                user.getPrice(),
                user.getUserId(),
                user.getCreatedAt()
        );
    }
}
