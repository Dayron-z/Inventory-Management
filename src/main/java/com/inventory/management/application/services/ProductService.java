package com.inventory.management.application.services;

import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.dto.response.ProductLightResponse;
import com.inventory.management.application.ports.in.ProductUseCase;
import com.inventory.management.application.ports.out.CategoryRepositoryPort;
import com.inventory.management.application.ports.out.ProductRepositoryPort;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;
import com.inventory.management.mapper.CategoryMapper;
import com.inventory.management.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final CategoryRepositoryPort categoryRepositoryPort;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = requestToDomain(productRequest);
        productRepositoryPort.save(product);
    }

    @Override
    public Page<ProductLightResponse> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        ProductEntity productEntity = productRepositoryPort.findById(id);
        return ProductMapper.entityToDomain(productEntity);
    }

    @Override
    public void editProduct(ProductRequest productRequest, Long id) {

    }

    @Override
    public void deleteProduct(Long id) {

    }

    private Product requestToDomain(ProductRequest pR) {
        CategoryEntity categoryEntity = this.categoryRepositoryPort.findById(pR.getCategoryId());
        Category category = CategoryMapper.entityToDomain(categoryEntity);
        return new Product(pR.getName(), pR.getDescription(), pR.getPrice(), pR.getStock(), category);
    }
}
