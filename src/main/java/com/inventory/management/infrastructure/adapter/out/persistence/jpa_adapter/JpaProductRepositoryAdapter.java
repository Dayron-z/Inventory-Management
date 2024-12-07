package com.inventory.management.infrastructure.adapter.out.persistence.jpa_adapter;

import com.inventory.management.application.ports.out.ProductRepositoryPort;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;


    @Override
    public void save(Product product) {
    }



}
