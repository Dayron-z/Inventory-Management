package com.inventory.management.infrastructure.adapter.in.rest;

import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.ports.in.ProductUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductUseCase productUseCase;


    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        productUseCase.createProduct(productRequest);
        return ResponseEntity.ok("Successfully created");
    }

}
