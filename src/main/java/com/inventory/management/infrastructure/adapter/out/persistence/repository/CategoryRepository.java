package com.inventory.management.infrastructure.adapter.out.persistence.repository;

import com.inventory.management.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
