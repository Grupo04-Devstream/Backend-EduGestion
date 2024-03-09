package com.example.backendedugestion.service.impl;

import com.example.backendedugestion.controller.request.AulaRequest;
import com.example.backendedugestion.repository.AulaJpaRepository;
import com.example.backendedugestion.repository.model.Aula;
import com.example.backendedugestion.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {
    @Autowired
    private AulaJpaRepository aulaJpaRepository;
    @Override
    public Aula save(AulaRequest aulaRequest){
        return aulaJpaRepository.save(toEntity(aulaRequest));
    }
    @Override
    public Aula findById(Integer id){
        return aulaJpaRepository.findById(id).orElse(null);
    }
    @Override
    public List<Aula> findAll(){
        return aulaJpaRepository.findAll();
    }
    @Override
    public boolean deleteById(Integer id){
        aulaJpaRepository.deleteById(id);
        return true;
    }
    @Override
    public Aula update(Integer id, AulaRequest aulaRequest){
        Aula aula1=aulaJpaRepository.findById(id).orElse(null);
        if(aula1==null){
            return null;
        }
        aula1.setCapacidad(aulaRequest.getCapacidad());
        aula1.setPiso(aulaRequest.getPiso());
        aula1.setDescripcion(aulaRequest.getDescripcion());
        aula1.setPabellon(aulaRequest.getPabellon());
        return aulaJpaRepository.save(aula1);
    }
    private Aula toEntity(AulaRequest aulaRequest){
        return Aula.builder().descripcion(aulaRequest.getDescripcion()).piso(aulaRequest.getPiso()).capacidad(aulaRequest.getCapacidad()).pabellon(aulaRequest.getPabellon()).build();

    }
}
