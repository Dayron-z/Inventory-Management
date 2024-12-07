package com.inventory.management.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String contactName;
    @Column(nullable = false, length = 50)
    private String address;
    @Column(nullable = false, length = 80)
    private String email;
    @Column(nullable = false, length = 50)
    private String phone;
}

