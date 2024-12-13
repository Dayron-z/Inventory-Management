package com.inventory.management.mapper;

import com.inventory.management.application.dto.response.InventoryMovementEntityLightResponse;
import com.inventory.management.infrastructure.entities.InventoryMovementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryManagementMapperMapStruct {

    @Named("mapInventoryMovements")
    default List<InventoryMovementEntityLightResponse> mapInventoryMovements(List<InventoryMovementEntity> movements) {
        return movements.stream()
                .map(this::entityToEntityResponse)
                .toList();
    }

    @Mapping(source = "id", target = "id")
    InventoryMovementEntityLightResponse entityToEntityResponse(InventoryMovementEntity inventoryMovement);
}
