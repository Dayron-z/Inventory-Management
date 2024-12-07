package com.inventory.management.application.dto.request;

import com.inventory.management.infrastructure.entities.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {
    @NotNull(message = "The name it can be null")
    private String name;
    @NotNull(message = "The description it can be null")
    private String description;
    private List<ProductEntity> products;
}
