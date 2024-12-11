package com.inventory.management.infrastructure.adapter.in.rest;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.response.CategoryLightResponse;
import com.inventory.management.application.ports.in.CategoryUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryUseCase categoryUseCase;

    @GetMapping
    public ResponseEntity<Page<CategoryLightResponse>> getAllCategories(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        page = Math.max(page, 1);
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));
        Page<CategoryLightResponse> categoriesPage = categoryUseCase.findAll(pageable);
        return ResponseEntity.ok(categoriesPage);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        categoryUseCase.createCategory(categoryRequest);
        return ResponseEntity.ok("Successfully created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editCategory(@RequestBody @Valid CategoryRequest categoryRequest, @PathVariable Long id) {
        categoryUseCase.editCategory(categoryRequest, id);
        return ResponseEntity.ok("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryUseCase.deleteCategory(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
