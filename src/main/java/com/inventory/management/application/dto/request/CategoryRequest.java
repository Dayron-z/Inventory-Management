package com.inventory.management.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {
    @NotNull(message = "The name cannot be null")
    @Size(min = 1, max = 100, message = "The name must have between 1 and 100 characters")
    private String name;

    @NotNull(message = "The description cannot be null")
    @Size(min = 1, max = 255, message = "The description must have between 1 and 255 characters")
    private String description;
}
