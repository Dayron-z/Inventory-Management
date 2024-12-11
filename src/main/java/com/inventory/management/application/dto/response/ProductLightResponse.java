package com.inventory.management.application.dto.response;

import com.inventory.management.infrastructure.entities.CategoryEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductLightResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private CategoryEntity category;
}
