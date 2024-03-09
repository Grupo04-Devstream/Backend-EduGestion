package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.RoleRequest;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.service.RoleService;
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
@WebMvcTest(RoleController.class)
class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService rolService;

    @Autowired
    private ObjectMapper objectMapper;

    private Role rol;

    @BeforeEach
    void setUp() {
        rol = new Role();
        rol.setId(90);
        rol.setNombre("Estudiante");
        rol.setDescripcion("Estudiante de la Institucion");
    }

    @Test
    void findAll() throws Exception {
        when(rolService.findAll()).thenReturn(List.of(rol));
        mockMvc.perform(get("/api/v1/rol"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(rol.getId()))
                .andExpect(jsonPath("$[0].nombre").value(rol.getNombre()))
                .andExpect((jsonPath("$[0].descripcion").value(rol.getDescripcion())));
    }

    @Test
    void findById() throws Exception {
        when(rolService.findById(1)).thenReturn(rol);
        mockMvc.perform(get("/api/v1/rol/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(rol.getId()))
                .andExpect(jsonPath("$.nombre").value(rol.getNombre()))
                .andExpect((jsonPath("$.descripcion").value(rol.getDescripcion())));
    }


    @Test
    void save() throws Exception {
        RoleRequest roleRequest =RoleRequest.builder()
                .nombre("Esudiante")
                .descripcion("Estudiante de la institucion")
                .build();
        when(rolService.save(any(RoleRequest.class))).thenReturn(rol);

        mockMvc.perform(post("/api/v1/rol")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(rol)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(rol.getId()))
                .andExpect(jsonPath("$.nombre").value(rol.getNombre()))
                .andExpect(jsonPath("$.descripcion").value(rol.getDescripcion()));
    }


}