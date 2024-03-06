package com.example.backendedugestion.repository;

import com.example.backendedugestion.repository.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoJpaRepository extends JpaRepository<Curso,Integer> {
}
