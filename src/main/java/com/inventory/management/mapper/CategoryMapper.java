package com.inventory.management.mapper;

import com.inventory.management.application.dto.response.CategoryDetailedResponse;
import com.inventory.management.application.dto.response.CategoryLightResponse;
import com.inventory.management.application.dto.response.ProductLightResponse;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryEntity domainToEntity(Category category) {
        return mapToEntity(category, null);  // No asignamos ID para creación
    }

    public static CategoryEntity domainToEntityWithId(Category category) {
        return mapToEntity(category, category.getId());  // Asignamos ID para actualizaciones
    }

    private static CategoryEntity mapToEntity(Category category, Long id) {
        return CategoryEntity.builder()
                .id(id)  // Asignar ID si es no-nulo
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    public static CategoryDetailedResponse entityToEntityResponse(CategoryEntity category) {
/*
        List<ProductLightResponse> products = category.getProducts().stream().map(ProductMapper::entityToProductLightResponse).collect(Collectors.toList());
*/


        return CategoryDetailedResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
/*                .products(products)*/
                .build();
    }

    public static Category entityToDomain(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        return new Category(
                categoryEntity.getId(),
                categoryEntity.getName(),
                categoryEntity.getDescription()
        );
    }

}
