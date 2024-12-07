package com.inventory.management.infrastructure.adapter.in.rest;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.ports.in.CategoryUseCase;
import com.inventory.management.application.ports.in.ProductUseCase;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryUseCase categoryUseCase;

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        categoryUseCase.createCategory(categoryRequest);
        return ResponseEntity.ok("Creado correctamente") ;
    }
}
