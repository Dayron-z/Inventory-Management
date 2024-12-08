package com.inventory.management.infrastructure.adapter.out.persistence.jpa_adapter;

import com.inventory.management.application.dto.response.CategoryResponse;
import com.inventory.management.application.ports.out.CategoryRepositoryPort;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.CategoryRepository;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaCategoryRepositoryAdapter implements CategoryRepositoryPort {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(Category category) {
        return categoryRepository.save(CategoryMapper.domainToEntity(category));
    }

    @Override
    public Page<CategoryResponse> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(CategoryMapper::entityToEntityResponse);
    }


}
