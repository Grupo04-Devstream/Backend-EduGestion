package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.AulaRequest;
import com.example.backendedugestion.repository.model.Aula;
import com.example.backendedugestion.service.AulaService;
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

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AulaController.class)
class AulaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AulaService aulaService;
    @Autowired
    ObjectMapper objectMapper;
    private Aula aula;
    @BeforeEach
    void setUp(){
        aula= new Aula();
        aula.setId(100);
        aula.setDescripcion("Azul");
        aula.setPabellon(2);
        aula.setPiso(1);
        aula.setCapacidad(50);
    }

    @Test
    void findAll() throws Exception{
        when(aulaService.findAll()).thenReturn(List.of(aula));
        mockMvc.perform(get("/api/v1/aula"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(aula.getId())).andExpect(jsonPath("$[0].descripcion").value(aula.getDescripcion())).andExpect(jsonPath("$[0].piso").value(aula.getPiso())).andExpect(jsonPath("$[0].capacidad").value(aula.getCapacidad())).andExpect(jsonPath("$[0].pabellon").value(aula.getPabellon()));
    }
    @Test
    void findById() throws Exception{
        when(aulaService.findById(1)).thenReturn(aula);
        mockMvc.perform(get("/api/v1/aula/{id}",1))
                .andExpect(status().isOk()).andExpect(jsonPath("$.id").value(aula.getId())).andExpect(jsonPath("$.descripcion").value(aula.getDescripcion())).andExpect(jsonPath("$.piso").value(aula.getPiso())).andExpect(jsonPath("$.capacidad").value(aula.getCapacidad())).andExpect(jsonPath("$.pabellon").value(aula.getPabellon()));
    }
    @Test
    void save() throws Exception{
        AulaRequest aulaRequest=AulaRequest.builder().descripcion("Azul").capacidad(50).pabellon(2).piso(1).build();
        when(aulaService.save(any(AulaRequest.class))).thenReturn(aula);
        mockMvc.perform(post("/api/v1/aula/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(aula)))
                .andExpect(status().isOk()).andExpect(jsonPath("$.id").value(aula.getId())).andExpect(jsonPath("$.descripcion").value(aula.getDescripcion())).andExpect(jsonPath("$.piso").value(aula.getPiso())).andExpect(jsonPath("$.capacidad").value(aula.getCapacidad())).andExpect(jsonPath("$.pabellon").value(aula.getPabellon()));

    }
    @Test
    void deleteById() throws Exception{
        when(aulaService.deleteById(100)).thenReturn(true);
        mockMvc.perform(delete("/api/v1/aula/{id}",1)).andExpect(status().isOk());
    }
    @Test
    void update() throws Exception{
        Integer id = 1;
        AulaRequest aulaRequest = AulaRequest.builder()
                .descripcion("Naranja")
                .piso(2)
                .capacidad(30)
                .pabellon(3)
                .build();
        Aula aula = new Aula();
        aula.setId(id);
        aula.setDescripcion("Azul");
        aula.setPiso(1);
        aula.setCapacidad(20);
        aula.setPabellon(2);
        when(aulaService.update(id, aulaRequest)).thenReturn(aula);
        mockMvc.perform(put("/api/v1/aula/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aulaRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(aula.getId()))
                .andExpect(jsonPath("$.descripcion").value(aula.getDescripcion()))
                .andExpect(jsonPath("$.piso").value(aula.getPiso()))
                .andExpect(jsonPath("$.capacidad").value(aula.getCapacidad()))
                .andExpect(jsonPath("$.pabellon").value(aula.getPabellon()));
    }

}
