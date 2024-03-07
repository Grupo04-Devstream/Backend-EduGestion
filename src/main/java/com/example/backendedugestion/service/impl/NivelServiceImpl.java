package com.example.backendedugestion.service.impl;

import com.example.backendedugestion.controller.request.NivelRequest;
import com.example.backendedugestion.repository.NivelJpaRepository;
import com.example.backendedugestion.repository.model.Nivele;
import com.example.backendedugestion.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelServiceImpl implements NivelService {

    @Autowired
    private NivelJpaRepository nivelJpaRepository;

    @Override
    public Nivele save(NivelRequest nivelRequest) {
        return nivelJpaRepository.save(toEntity(nivelRequest));
    }

    @Override
    public Nivele findById(Integer id) {
        return nivelJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Nivele> findAll() {
        return nivelJpaRepository.findAll();
    }
    @Override
    public boolean deleteById(Integer id) {
        nivelJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public Nivele update(Integer id, NivelRequest nivelRequest) {
        Nivele nivel = nivelJpaRepository.findById(id).orElse(null);
        if (nivel == null) {
            return null;
        }
        nivel.setNombre(nivelRequest.getNombre());
        return nivelJpaRepository.save(nivel);
    }

    private Nivele toEntity(NivelRequest nivelRequest) {
        return Nivele.builder()
                .nombre(nivelRequest.getNombre())
                .build();
    }
}
