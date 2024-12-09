package com.inventory.management.application.ports.in;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryUseCase {
    void createCategory(CategoryRequest categoryRequest);
    Page<CategoryResponse> findAll(Pageable pageable);
}
