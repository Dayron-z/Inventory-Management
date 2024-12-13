package com.inventory.management.application.services;

import com.inventory.management.application.dto.request.CategoryRequest;
import com.inventory.management.application.dto.response.CategoryDetailedResponse;
import com.inventory.management.application.dto.response.CategoryLightResponse;
import com.inventory.management.application.ports.in.CategoryUseCase;
import com.inventory.management.application.ports.out.CategoryRepositoryPort;
import com.inventory.management.domain.entities.Category;
import com.inventory.management.infrastructure.entities.CategoryEntity;
import com.inventory.management.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService implements CategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestToDomain(categoryRequest);
        categoryRepositoryPort.save(category);
    }


    @Override
    public Page<CategoryDetailedResponse> findAll(Pageable pageable) {
        return categoryRepositoryPort.findAll(pageable);
    }

    @Override
    public Category findById(Long id) {
        CategoryEntity categoryEntity = categoryRepositoryPort.findById(id);
        return CategoryMapper.entityToDomain(categoryEntity);
    }


    @Override
    public void editCategory(CategoryRequest cR, Long id) {
        Category category = findById(id);
        category.setName(cR.getName());
        category.setDescription(cR.getDescription());
        categoryRepositoryPort.edit(category);
    }

    @Override
    public void deleteCategory(Long id) {
        findById(id);
        categoryRepositoryPort.delete(id);
    }

    private Category categoryRequestToDomain(CategoryRequest cR) {
        return new Category(cR.getName(), cR.getDescription());
    }
}
