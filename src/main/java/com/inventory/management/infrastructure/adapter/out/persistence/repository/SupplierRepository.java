package com.inventory.management.infrastructure.adapter.out.persistence.repository;

import com.inventory.management.infrastructure.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
}
