package com.inventory.management.mapper;

import com.inventory.management.application.dto.response.InventoryMovementEntityLightResponse;
import com.inventory.management.application.dto.response.ProductDetailedResponse;
import com.inventory.management.application.dto.response.ProductLightResponse;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.entities.ProductEntity;

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
    public static ProductLightResponse entityToProductLightResponse(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        return ProductLightResponse.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .stock(productEntity.getStock())
                .build();
    }
    public static ProductDetailedResponse entityToProductDetailedResponse(ProductEntity productEntity) {
        List<InventoryMovementEntityLightResponse > inventoryResponse = productEntity.getMovement().stream().map(InventoryMapper::entityToEntityResponse).toList();

        return ProductDetailedResponse.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .stock(productEntity.getStock())
                .movement(inventoryResponse)
                .build();
    }
}
