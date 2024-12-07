package com.inventory.management.infrastructure.adapter.out.persistence.repository;

import com.inventory.management.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
