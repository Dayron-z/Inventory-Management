package com.inventory.management.mapper;

import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryEntity domainToEntity(Category category) {
        List<ProductEntity> productEntities = category.getProducts().stream().map(ProductMapper::domainToEntity).toList();

        return CategoryEntity.builder()
                .name(category.getName())
                .description(category.getDescription())
                .products(productEntities)
                .build();
    }
}
