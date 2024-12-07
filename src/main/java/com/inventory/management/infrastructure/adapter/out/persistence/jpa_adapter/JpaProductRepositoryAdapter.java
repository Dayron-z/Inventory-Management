package com.inventory.management.infrastructure.adapter.out.persistence.jpa_adapter;

import com.inventory.management.application.ports.out.ProductRepositoryPort;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.ProductRepository;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.InventoryMovementEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;


    @Override
    public void save(Product product) {
    }



}
