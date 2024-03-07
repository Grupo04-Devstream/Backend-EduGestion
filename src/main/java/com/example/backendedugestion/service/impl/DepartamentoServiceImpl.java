package com.example.backendedugestion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backendedugestion.repository.DepartamentoJpaRepository;
import com.example.backendedugestion.repository.model.Departamento;
import com.example.backendedugestion.service.DepartamentoService;

@Component
public class DepartamentoServiceImpl implements DepartamentoService{
    @Autowired
    private DepartamentoJpaRepository departamentoJpaRepository;

    @Override
    public Departamento save(Departamento departamento) {
        return departamentoJpaRepository.save(departamento);
    }

    @Override
    public Optional<Departamento> findById(Integer id) {
        return departamentoJpaRepository.findById(id);
    }

    @Override
    public List<Departamento> findAll() {
        return departamentoJpaRepository.findAll();
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<Departamento> departamento = findById(id);
        if (departamento.isPresent()) {
            departamentoJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Departamento Update(Departamento departamento) {
        return departamentoJpaRepository.save(departamento);
    }
    
}
