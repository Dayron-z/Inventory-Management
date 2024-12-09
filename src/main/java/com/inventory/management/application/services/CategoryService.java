package com.inventory.management.application.services;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.dto.response.CategoryResponse;
import com.inventory.management.application.ports.in.CategoryUseCase;
import com.inventory.management.application.ports.in.ProductUseCase;
import com.inventory.management.application.ports.out.CategoryRepositoryPort;
import com.inventory.management.application.ports.out.ProductRepositoryPort;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService implements CategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = requestToDomain(categoryRequest);
        categoryRepositoryPort.save(category);
    }

    @Override
    public Page<CategoryResponse> findAll(Pageable pageable) {
        return categoryRepositoryPort.findAll(pageable);
    }

    private Category requestToDomain(CategoryRequest cR) {
        return new Category(cR.getName(), cR.getDescription());
    }
}
