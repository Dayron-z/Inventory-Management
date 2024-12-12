package com.inventory.management.application.ports.out;

import com.inventory.management.application.dto.response.CategoryLightResponse;
import com.inventory.management.application.dto.response.ProductLightResponse;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryPort {
    void save(Product product);
    Page<ProductEntity> findAll(Pageable pageable);
    ProductEntity findById(Long id);
    ProductEntity edit(Product category);
    void delete (Long id);
}
