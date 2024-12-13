package com.inventory.management.application.ports.out;

import com.inventory.management.application.dto.response.InventoryMovementEntityLightResponse;
import com.inventory.management.domain.entities.InventoryMovement;
import com.inventory.management.infrastructure.entities.InventoryMovementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventoryMovementRepositoryPort {
    InventoryMovementEntity save(InventoryMovement inventoryMovement);
    Page<InventoryMovementEntityLightResponse> findAll(Pageable pageable);
    InventoryMovementEntity findById(Long id);
    InventoryMovementEntity edit(InventoryMovement category);
    void delete (Long id);
}
