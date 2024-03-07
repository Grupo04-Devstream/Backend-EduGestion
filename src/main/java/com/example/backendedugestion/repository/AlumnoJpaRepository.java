package com.example.backendedugestion.repository;

import com.example.backendedugestion.repository.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlumnoJpaRepository extends JpaRepository<Alumno, Integer> {
}
