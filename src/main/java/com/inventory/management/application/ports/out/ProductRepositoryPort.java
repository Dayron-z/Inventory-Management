package com.inventory.management.application.ports.out;

import com.inventory.management.domain.entities.Product;

public interface ProductRepositoryPort {
    void save(Product product);
}
