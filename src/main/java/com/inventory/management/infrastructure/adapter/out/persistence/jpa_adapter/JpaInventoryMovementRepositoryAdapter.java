package com.inventory.management.infrastructure.adapter.out.persistence.jpa_adapter;


import com.inventory.management.application.dto.response.InventoryMovementEntityLightResponse;
import com.inventory.management.application.ports.out.InventoryMovementRepositoryPort;
import com.inventory.management.domain.entities.InventoryMovement;
import com.inventory.management.infrastructure.adapter.out.persistence.repository.InventoryMovementRepository;
import com.inventory.management.infrastructure.entities.InventoryMovementEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaInventoryMovementRepositoryAdapter implements InventoryMovementRepositoryPort {
    private final InventoryMovementRepository inventoryMovementRepository;


    @Override
    public InventoryMovementEntity save(InventoryMovement inventoryMovement) {
        return null;
    }

    @Override
    public Page<InventoryMovementEntityLightResponse> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public InventoryMovementEntity findById(Long id) {
        return null;
    }

    @Override
    public InventoryMovementEntity edit(InventoryMovement category) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
