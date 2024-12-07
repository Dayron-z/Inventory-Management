package com.inventory.management.application.ports.in;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.request.ProductRequest;

public interface CategoryUseCase {
    void createCategory(CategoryRequest categoryRequest);
}
