package com.example.backendedugestion.repository;

import com.example.backendedugestion.repository.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<Role,Integer> {
}
