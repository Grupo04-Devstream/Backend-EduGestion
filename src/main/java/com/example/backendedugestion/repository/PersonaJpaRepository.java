package com.example.backendedugestion.repository;

import com.example.backendedugestion.repository.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaJpaRepository extends JpaRepository<Persona, Long> {
}
