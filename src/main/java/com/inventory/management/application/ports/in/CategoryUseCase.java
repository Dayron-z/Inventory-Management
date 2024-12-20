package com.inventory.management.application.ports.in;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.response.CategoryDetailedResponse;
import com.inventory.management.application.dto.response.CategoryLightResponse;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryUseCase {
    void createCategory(CategoryRequest categoryRequest);
    Page<CategoryDetailedResponse> findAll(Pageable pageable);
    Category findById(Long id);
    void editCategory(CategoryRequest categoryRequest, Long id);
    void deleteCategory(Long id);
}
