package com.example.backendedugestion.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.backendedugestion.repository.model.Departamento;
import com.example.backendedugestion.service.DepartamentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DepartamentoController.class)
class DepartamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartamentoService departamentoService;

    @Autowired
    private ObjectMapper objectMapper;

    private Departamento departamento;

    @BeforeEach
    void setUp(){
        departamento= new Departamento();
        departamento.setId(1);
        departamento.setNombre("Administración");
        departamento.setDescripcion("Encargados de gestionar");
    }

    @Test
    void findAll() throws Exception{
        when(departamentoService.findAll()).thenReturn(List.of(departamento));

        mockMvc.perform(get("/api/v1/departamento"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(departamento.getId()))
                .andExpect(jsonPath("$[0].nombre").value(departamento.getNombre()))
                .andExpect(jsonPath("$[0].descripcion").value(departamento.getDescripcion()));
    }

    @Test
    void findById() throws Exception{
        when(departamentoService.findById(1)).thenReturn(Optional.of(departamento));

        mockMvc.perform(get("/api/v1/departamento/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(departamento.getId()))
                .andExpect(jsonPath("$.nombre").value(departamento.getNombre()))
                .andExpect(jsonPath("$.descripcion").value(departamento.getDescripcion()));
    }

    @Test
    void save() throws Exception {
        when(departamentoService.save(any(Departamento.class))).thenReturn(departamento);

        mockMvc.perform(post("/api/v1/departamento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(departamento)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(departamento.getId()))
                .andExpect(jsonPath("$.nombre").value(departamento.getNombre()))
                .andExpect(jsonPath("$.descripcion").value(departamento.getDescripcion()));

    }

    @Test
    void deleteById() throws Exception {
        when(departamentoService.deleteById(1)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/departamento/{id}", 1))
                .andExpect(status().isOk());
    }
}