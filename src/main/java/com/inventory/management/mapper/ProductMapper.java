package com.inventory.management.mapper;

import com.inventory.management.domain.entities.Category;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.InventoryMovementEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductMapper {
    public static ProductEntity domainToEntity(Product product) {

        return ProductEntity.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .category(CategoryMapper.domainToEntityWithId(product.getCategory()))
                .build();
    }


    public static Product entityToDomain(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        return new Product(
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getStock()
        );
    }




}
