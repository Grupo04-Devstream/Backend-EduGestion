package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.AulaRequest;
import com.example.backendedugestion.repository.model.Aula;

import java.util.List;

public interface AulaService {
    Aula save(AulaRequest aulaRequest);
    Aula findById(Integer id);
    List<Aula> findAll();
    boolean deleteById(Integer id);
    Aula update(Integer id, AulaRequest aulaRequest);

}
