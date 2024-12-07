package com.inventory.management.mapper;

import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.entities.ProductEntity;

public class ProductMapper {
    public static ProductEntity domainToEntity(Product product) {
        return ProductEntity.builder()
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }
}
