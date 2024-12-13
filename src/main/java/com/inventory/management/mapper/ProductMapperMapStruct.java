package com.inventory.management.mapper;

import com.inventory.management.application.dto.response.ProductDetailedResponse;
import com.inventory.management.application.dto.response.ProductLightResponse;
import com.inventory.management.domain.entities.Product;
import com.inventory.management.infrastructure.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {CategoryMapperMapStruct.class, InventoryManagementMapperMapStruct.class})
public interface ProductMapperMapStruct {
    @Mapping(source = "category", target = "category", qualifiedByName = "mapCategoryWithId")
    @Mapping(target = "movement", ignore = true)
    ProductEntity domainToEntity(Product product);

    Product entityToDomain(ProductEntity productEntity);

    ProductLightResponse entityToProductLightResponse(ProductEntity productEntity);

    @Mapping(source = "movement", target = "movement", qualifiedByName = "mapInventoryMovements")
    ProductDetailedResponse entityToProductDetailedResponse(ProductEntity productEntity);
}
