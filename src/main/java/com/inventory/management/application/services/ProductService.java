package com.inventory.management.application.services;

import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.ports.in.ProductUseCase;
import com.inventory.management.application.ports.out.ProductRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements ProductUseCase {

    @Autowired
    private final ProductRepositoryPort productRepositoryPort;


    @Override
    public void createProduct(ProductRequest productRequest) {
    }
}
