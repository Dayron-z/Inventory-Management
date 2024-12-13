package com.inventory.management.infrastructure.adapter.out.persistence.jpa_adapter;

import com.inventory.management.application.dto.response.CategoryDetailedResponse;
import com.inventory.management.application.ports.out.CategoryRepositoryPort;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.CategoryRepository;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.mapper.CategoryMapper;
import com.inventory.management.mapper.CategoryMapperMapStruct;
import com.inventory.management.mapper.ProductMapperMapStruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaCategoryRepositoryAdapter implements CategoryRepositoryPort {
    @Autowired
    private final CategoryMapperMapStruct categoryMapperMapStruct;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(Category category) {
        return categoryRepository.save(categoryMapperMapStruct.domainToEntity(category));
    }

    @Override
    public Page<CategoryDetailedResponse> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapperMapStruct::entityToEntityResponse);
    }

    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The supplied id does not correspond to any category."));
    }

    @Override
    public CategoryEntity edit(Category category) {
        return categoryRepository.save(categoryMapperMapStruct.domainToEntityWithId(category));
    }

    @Override
    public void delete(Long id) {
         categoryRepository.deleteById(id);
    }
}
