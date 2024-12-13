package com.inventory.management.application.ports.in;

import com.inventory.management.application.dto.request.ProductRequest;
import com.inventory.management.application.dto.response.ProductDetailedResponse;
import com.inventory.management.domain.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductUseCase {
    void createProduct(ProductRequest productRequest);
    Page<ProductDetailedResponse> findAll(Pageable pageable);
    Product findById(Long id);
    void editProduct(ProductRequest productRequest, Long id);
    void deleteProduct(Long id);
}
