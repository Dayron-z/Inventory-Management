package com.inventory.management.application.dto.response;


import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDetailedResponse {
    private Long id;
    private String name;
    private String description;
    private List<ProductLightResponse> products;
}
