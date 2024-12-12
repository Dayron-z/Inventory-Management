package com.inventory.management.application.dto.request;



import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    @NotNull(message = "Name cannot be null.")
    @NotEmpty(message = "Name cannot be empty.")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters.")
    private String name;

    @NotNull(message = "Description cannot be null.")
    @NotEmpty(message = "Description cannot be empty.")
    @Size(min = 5, max = 255, message = "Description must be between 5 and 255 characters.")
    private String description;

    @NotNull(message = "Price cannot be null.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.")
    private BigDecimal price;

    @Min(value = 0, message = "Stock cannot be negative.")
    private int stock;

    @NotNull(message = "Category ID cannot be null.")
    private Long categoryId;
}