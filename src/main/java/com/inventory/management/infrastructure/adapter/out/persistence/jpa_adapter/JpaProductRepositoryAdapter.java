package com.inventory.management.infrastructure.adapter.out.persistence.jpa_adapter;

import com.inventory.management.application.ports.out.ProductRepositoryPort;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.ProductRepository;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.InventoryMovementEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;

    CategoryEntity category = new CategoryEntity();
    List<InventoryMovementEntity> movementEntities = new ArrayList<>();

    @Override
    public void save(Product product) {
        ProductEntity productEntity = new ProductEntity(
                product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock(), category, movementEntities
        );
        productRepository.save(productEntity);
    }
}
