package com.inventory.management.mapper;

import com.inventory.management.application.dto.response.CategoryDetailedResponse;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CategoryMapperMapStruct {
    @Mapping(target = "id", ignore = true)
    CategoryEntity domainToEntity(Category category);

    @Named("mapCategoryWithId")
    CategoryEntity domainToEntityWithId(Category category);

    CategoryDetailedResponse entityToEntityResponse(CategoryEntity category);

    Category entityToDomain(CategoryEntity categoryEntity);
}
