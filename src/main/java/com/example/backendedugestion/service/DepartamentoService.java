package com.example.backendedugestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.backendedugestion.repository.model.Departamento;

@Service
public interface DepartamentoService {
    Departamento save(Departamento departamento);
    Optional<Departamento> findById(Integer id);
    List<Departamento> findAll();
    boolean deleteById(Integer id);
    Departamento Update(Departamento departamento);
}
