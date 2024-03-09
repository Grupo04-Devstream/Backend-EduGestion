package com.example.backendedugestion.service.impl;

import com.example.backendedugestion.controller.request.NivelRequest;
import com.example.backendedugestion.repository.NivelJpaRepository;
import com.example.backendedugestion.repository.model.Nivele;
import com.example.backendedugestion.service.NivelService;
import com.example.backendedugestion.service.exception.NotFoundTipoDocumentoException;
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
        Nivele nivele = nivelJpaRepository.findById(id).orElse(null);
        if(nivele == null){
            throw new NotFoundTipoDocumentoException("El tipo de documento no existe");
        }
        return nivele;
    }

    @Override
    public List<Nivele> findAll() {
        return nivelJpaRepository.findAll();
    }

    @Override
    public Nivele delete(Integer id) {
        Nivele nivele = nivelJpaRepository.findById(id).orElse(null);
        if(nivele == null){
            throw new NotFoundTipoDocumentoException("El tipo de documento no existe");
        }
        nivelJpaRepository.delete(nivele);
        return nivele;
    }
    @Override
    public Nivele update(Nivele nivelRequest) {
        Nivele nivele = nivelJpaRepository.findById(nivelRequest.getId()).orElse(null);
        if(nivele == null){
            throw new NotFoundTipoDocumentoException("El tipo de documento no existe");
        }
        nivele.setNombre(nivelRequest.getNombre());
        return nivelJpaRepository.save(nivele);
    }

    private Nivele toEntity(NivelRequest nivelRequest) {
        return Nivele.builder()
                .nombre(nivelRequest.getNombre())
                .build();
    }
}
