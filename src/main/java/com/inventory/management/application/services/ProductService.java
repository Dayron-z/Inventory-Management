package com.inventory.management.application.services;

import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.dto.response.ProductDetailedResponse;
import com.inventory.management.application.ports.in.ProductUseCase;
import com.inventory.management.application.ports.out.CategoryRepositoryPort;
import com.inventory.management.application.ports.out.InventoryMovementRepositoryPort;
import com.inventory.management.application.ports.out.ProductRepositoryPort;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.InventoryMovementRepository;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.infrastructure.entities.ProductEntity;
import com.inventory.management.mapper.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final ProductMapperMapStruct productMapperMapStruct;
    private final CategoryMapperMapStruct categoryMapperMapStruct;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = requestToDomain(productRequest);
        productRepositoryPort.save(product);
    }

    @Override
    public Page<ProductDetailedResponse> findAll(Pageable pageable) {
        return this.productRepositoryPort.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        ProductEntity productEntity = productRepositoryPort.findById(id);
        return productMapperMapStruct.entityToDomain(productEntity);
    }

    @Override
    public void editProduct(ProductRequest productRequest, Long id) {
        Product product = this.findById(id);
        CategoryEntity categoryEntity = categoryRepositoryPort.findById(productRequest.getCategoryId());
        Category category = categoryMapperMapStruct.entityToDomain(categoryEntity);
        product.setCategory(category);
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        productRepositoryPort.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepositoryPort.delete(id);
    }

    private Product requestToDomain(ProductRequest pR) {
            CategoryEntity categoryEntity = this.categoryRepositoryPort.findById(pR.getCategoryId());
            Category category = categoryMapperMapStruct.entityToDomain(categoryEntity);
            return new Product(pR.getName(), pR.getDescription(), pR.getPrice(), pR.getStock(), category);
        }
}
