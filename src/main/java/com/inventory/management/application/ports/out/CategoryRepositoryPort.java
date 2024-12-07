package com.inventory.management.application.ports.out;

import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;

public interface CategoryRepositoryPort {
    CategoryEntity save(Category category);
}
