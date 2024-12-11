package com.inventory.management.mapper;

import com.inventory.management.application.dto.response.CategoryLightResponse;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;

import java.util.List;

public class CategoryMapper {
    public static CategoryEntity domainToEntity(Category category) {
        List<ProductEntity> productEntities = category.getProducts().stream().map(ProductMapper::domainToEntity).toList();

        return CategoryEntity.builder()
                .name(category.getName())
                .description(category.getDescription())
                .products(productEntities)
                .build();
    }

    public static CategoryEntity domainToEntityForUpdate(Category category) {
        List<ProductEntity> productEntities = category.getProducts().stream()
                .map(ProductMapper::domainToEntity)
                .toList();

        return CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .products(productEntities)
                .build();
    }




    public static CategoryLightResponse entityToEntityResponse(CategoryEntity category) {
        return CategoryLightResponse.builder()
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }


}
