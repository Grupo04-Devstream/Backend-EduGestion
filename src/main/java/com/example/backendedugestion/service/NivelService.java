package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.NivelRequest;
import com.example.backendedugestion.repository.model.Nivele;

import java.util.List;

public interface NivelService {
    Nivele save(NivelRequest nivelRequest);

    Nivele findById(Integer id);

    List<Nivele> findAll();

    Nivele delete(Integer id);

    Nivele update(Nivele nivelRequest);
}