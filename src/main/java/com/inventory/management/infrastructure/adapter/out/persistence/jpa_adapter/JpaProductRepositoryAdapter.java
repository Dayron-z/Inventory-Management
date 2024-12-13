package com.inventory.management.infrastructure.adapter.out.persistence.jpa_adapter;


import com.inventory.management.application.dto.response.ProductDetailedResponse;
import com.inventory.management.application.ports.out.ProductRepositoryPort;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.ProductRepository;
import com.inventory.management.infrastructure.entities.ProductEntity;
import com.inventory.management.mapper.ProductMapper;
import com.inventory.management.mapper.ProductMapperMapStruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;
    @Autowired
    private final ProductMapperMapStruct productMapperMapStruct;


    @Override
    public void save(Product product) {
        ProductEntity productEntity = productMapperMapStruct.domainToEntity(product);
        productRepository.save(productEntity);
    }

    @Override
    public Page<ProductDetailedResponse> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(productMapperMapStruct::entityToProductDetailedResponse);
    }

    @Override
    public ProductEntity findById(Long id) {
        return null;
    }

    @Override
    public ProductEntity edit(Product category) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }


}
