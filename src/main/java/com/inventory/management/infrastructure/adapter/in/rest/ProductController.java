package com.inventory.management.infrastructure.adapter.in.rest;

import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.ports.in.ProductUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductUseCase productUseCase;

    @PostMapping
    public void createProduct(@RequestBody  ProductRequest product) {
        productUseCase.createProduct(product);
    }
}
