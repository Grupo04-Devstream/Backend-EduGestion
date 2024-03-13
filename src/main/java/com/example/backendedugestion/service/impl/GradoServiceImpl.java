package com.example.backendedugestion.service.impl;


import com.example.backendedugestion.controller.request.GradoRequest;
import com.example.backendedugestion.repository.GradoJpaRepository;
import com.example.backendedugestion.repository.model.Grado;
import com.example.backendedugestion.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GradoServiceImpl implements GradoService {

    @Autowired
    private GradoJpaRepository gradoJpaRepository;

    @Override
    public Grado save(GradoRequest gradoRequest) {
        return gradoJpaRepository.save(toEntity(gradoRequest));
    }

    @Override
    public Grado findById(Integer id) {
        return gradoJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Grado> findAll() {
        return gradoJpaRepository.findAll();
    }

    @Override
    public boolean deleteById(Integer id) {
        gradoJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public Grado update(Integer id, GradoRequest gradoRequest) {
        Grado grado=gradoJpaRepository.findById(id).orElse(null);
        if(grado==null){
            return null;
        }
        grado.setGradonro(gradoRequest.getGradonro());

        return gradoJpaRepository.save(grado);
    }

    private Grado toEntity(GradoRequest gradoRequest){
        return Grado.builder().gradonro(gradoRequest.getGradonro()).build();

    }

}

