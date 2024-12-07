package com.inventory.management.application.ports.in;

import com.inventory.management.application.dto.request.ProductRequest;

public interface ProductUseCase {
    void createProduct(ProductRequest productRequest);
}
