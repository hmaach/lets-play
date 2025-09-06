package com.letsplay.application.controller;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsplay.domain.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final MongoTemplate mongoTemplate;

    public ProductController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping
    public List<Product> getProducts() {
        return mongoTemplate.findAll(Product.class, "products");
    }
}
