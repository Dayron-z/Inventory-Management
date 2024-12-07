package com.inventory.management.infrastructure.adapter.out.persistence.repository;


import com.inventory.management.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
    