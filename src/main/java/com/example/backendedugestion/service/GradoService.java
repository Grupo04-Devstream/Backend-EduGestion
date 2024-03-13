package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.GradoRequest;
import com.example.backendedugestion.repository.model.Grado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GradoService {

    Grado findById(Integer id);
    List<Grado> findAll();
    Grado save(GradoRequest gradoRequest);
    boolean deleteById(Integer id);
    Grado update(Integer Id, GradoRequest gradoRequest);

}
