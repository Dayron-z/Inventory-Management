package com.inventory.management.application.ports.out;

import com.inventory.management.application.dto.response.CategoryResponse;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryRepositoryPort {
    CategoryEntity save(Category category);
    Page<CategoryResponse> findAll(Pageable pageable);
}
