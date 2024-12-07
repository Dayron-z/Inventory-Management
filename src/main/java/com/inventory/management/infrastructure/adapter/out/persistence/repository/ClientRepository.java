package com.inventory.management.infrastructure.adapter.out.persistence.repository;

import com.inventory.management.infrastructure.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
