package com.inventory.management.domain.entities;

import com.inventory.management.domain.enums.MovementType;

import java.time.LocalDateTime;

public class InventoryMovement {
    private Long id;
    private MovementType movementType;
    private LocalDateTime movementDateTime;
    private Integer quantity;
    private DomainUser user;
    private Product productId;

    public InventoryMovement(Long id, MovementType movementType, LocalDateTime movementDateTime, Integer quantity, DomainUser user, Product productId) {
        this.id = id;
        this.movementType = movementType;
        this.movementDateTime = movementDateTime;
        this.quantity = quantity;
        this.user = user;
        this.productId = productId;
    }

    public InventoryMovement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public LocalDateTime getMovementDateTime() {
        return movementDateTime;
    }

    public void setMovementDateTime(LocalDateTime movementDateTime) {
        this.movementDateTime = movementDateTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public DomainUser getUser() {
        return user;
    }

    public void setUser(DomainUser user) {
        this.user = user;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}
