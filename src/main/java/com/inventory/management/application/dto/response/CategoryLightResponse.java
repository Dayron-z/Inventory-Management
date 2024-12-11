package com.inventory.management.application.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryLightResponse {
    private String name;
    private String description;
}
