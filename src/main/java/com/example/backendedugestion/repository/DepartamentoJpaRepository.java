package com.example.backendedugestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendedugestion.repository.model.Departamento;

public interface DepartamentoJpaRepository extends JpaRepository<Departamento,Integer>{
    
}