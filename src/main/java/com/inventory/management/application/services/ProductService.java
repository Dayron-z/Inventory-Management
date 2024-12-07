package com.inventory.management.application.services;

import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.ports.in.ProductUseCase;
import com.inventory.management.application.ports.out.ProductRepositoryPort;
import com.inventory.management.domain.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = requestToDomain(productRequest);
        productRepositoryPort.save(product);
    }

    private Product requestToDomain(ProductRequest pR) {
        return new Product(pR.getName(), pR.getDescription(), pR.getPrice(), pR.getStock(), pR.getCategoryId());
    }
}
