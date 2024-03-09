package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.NivelRequest;
import com.example.backendedugestion.repository.model.Nivele;
import com.example.backendedugestion.service.NivelService;
import com.example.backendedugestion.service.exception.NotFoundTipoDocumentoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(NivelController.class)
class NivelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NivelService nivelService;

    @Autowired
    private ObjectMapper objectMapper;

    private Nivele nivel;

    @BeforeEach
    void setUp() {
        nivel = new Nivele();
        nivel.setId(90);
        nivel.setNombre("Primaria");
    }

    @Test
    void findAll() throws Exception {
        when(nivelService.findAll()).thenReturn(List.of(nivel));
        mockMvc.perform(get("/api/v1/nivel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(nivel.getId()))
                .andExpect(jsonPath("$[0].nombre").value(nivel.getNombre()));
    }

    @Test
    void findById() throws Exception {
        when(nivelService.findById(1)).thenReturn(nivel);
        mockMvc.perform(get("/api/v1/nivel/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(nivel.getId()))
                .andExpect(jsonPath("$.nombre").value(nivel.getNombre()));
    }


    @Test
    void save() throws Exception {
        NivelRequest nivelRequest =NivelRequest.builder()
                .nombre("Primaria")
                .build();
        when(nivelService.save(any(NivelRequest.class))).thenReturn(nivel);

        mockMvc.perform(post("/api/v1/nivel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nivel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(nivel.getId()))
                .andExpect(jsonPath("$.nombre").value(nivel.getNombre()));
    }




}