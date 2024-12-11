package com.inventory.management.application.ports.in;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.response.ProductLightResponse;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductUseCase {
    void createProduct(CategoryRequest categoryRequest);
    Page<ProductLightResponse> findAll(Pageable pageable);
    CategoryEntity findById(Long id);
    void editCategory(CategoryRequest categoryRequest, Long id);
    void deleteCategory(Long id);
}
