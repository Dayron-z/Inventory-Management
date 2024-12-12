package com.inventory.management.infrastructure.adapter.out.persistence.jpa_adapter;

import com.inventory.management.application.dto.response.CategoryLightResponse;
import com.inventory.management.application.ports.out.CategoryRepositoryPort;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.CategoryRepository;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.mapper.CategoryMapper;
import jakarta.persistence.EntityNotFoundException;
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
    public Page<CategoryLightResponse> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(CategoryMapper::entityToEntityResponse);
    }

    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The supplied id does not correspond to any category."));
    }

    @Override
    public CategoryEntity edit(Category category) {
        return categoryRepository.save(CategoryMapper.domainToEntityWithId(category));
    }

    @Override
    public void delete(Long id) {
         categoryRepository.deleteById(id);
    }
}
