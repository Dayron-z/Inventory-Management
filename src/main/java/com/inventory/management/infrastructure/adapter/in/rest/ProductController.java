package com.inventory.management.infrastructure.adapter.in.rest;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.dto.response.ProductDetailedResponse;
import com.inventory.management.application.ports.in.ProductUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductUseCase productUseCase;


    @GetMapping
    public ResponseEntity<Page<ProductDetailedResponse>> getAllProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        page = Math.max(page, 1);
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));
        Page<ProductDetailedResponse> productPage = productUseCase.findAll(pageable);
        return ResponseEntity.ok(productPage);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        productUseCase.createProduct(productRequest);
        return ResponseEntity.ok("Successfully created");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> editProduct(@RequestBody @Valid ProductRequest productRequest, @PathVariable Long id) {
        productUseCase.editProduct(productRequest, id);
        return ResponseEntity.ok("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productUseCase.deleteProduct(id);
        return ResponseEntity.ok("Successfully deleted");
    }

}
