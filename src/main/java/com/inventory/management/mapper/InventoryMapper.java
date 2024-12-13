package com.inventory.management.mapper;

import com.inventory.management.application.dto.response.InventoryMovementEntityLightResponse;
import com.inventory.management.infrastructure.entities.InventoryMovementEntity;

public class InventoryMapper {
    public static InventoryMovementEntityLightResponse entityToEntityResponse(InventoryMovementEntity inventoryMovement) {
        return InventoryMovementEntityLightResponse.builder()
                .id(inventoryMovement.getId())
                .movementType(inventoryMovement.getMovementType())
                .movementDateTime(inventoryMovement.getMovementDateTime())
                .quantity(inventoryMovement.getQuantity())
                .build();
    }
}
