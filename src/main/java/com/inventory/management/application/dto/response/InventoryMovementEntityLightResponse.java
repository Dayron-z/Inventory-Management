package com.inventory.management.application.dto.response;

import com.inventory.management.domain.enums.MovementType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryMovementEntityLightResponse {
    private Long id;
    private MovementType movementType;
    private LocalDateTime movementDateTime;
    private Integer quantity;
}
