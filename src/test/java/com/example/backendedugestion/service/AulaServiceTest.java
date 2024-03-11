package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.AulaRequest;
import com.example.backendedugestion.repository.AulaJpaRepository;
import com.example.backendedugestion.repository.model.Aula;
import com.example.backendedugestion.service.impl.AulaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
class AulaServiceTest {
    @Mock
    private AulaJpaRepository aulaJpaRepository;
    @InjectMocks
    private AulaServiceImpl aulaService;
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
    void save(){
        AulaRequest aulaRequest=AulaRequest.builder().descripcion("Azul").capacidad(50).pabellon(2).piso(1).build();
        Aula aula=Aula.builder()
                .capacidad(50)
                .pabellon(2)
                .piso(1)
                .descripcion("Azul")
                .build();
        doReturn(Optional.of(aula)).when(aulaJpaRepository).findById(any(Integer.class));
        when(aulaJpaRepository.save(any(Aula.class))).thenReturn(aula);
        Aula aulaResponse = aulaService.save(aulaRequest);
        assertNotNull(aulaResponse);
        assertEquals(aulaResponse, aula);
    }
    @Test
    void findById() {
        when(aulaJpaRepository.findById(any(Integer.class))).thenReturn(Optional.of(aula));
        Aula aulaResponse = aulaService.findById(1);
        assertNotNull(aulaResponse);
        assertEquals(aulaResponse, aula);
    }
    @Test
    void findAll() {
        when(aulaJpaRepository.findAll()).thenReturn(List.of(aula));

        List<Aula> aulas = aulaService.findAll();
        assertFalse(aulas.isEmpty());
        assertEquals(aula, aulas.get(0));
    }
    @Test
    void deleteById() {
        when(aulaJpaRepository.findById(1)).thenReturn(Optional.of(aula));
        boolean result = aulaService.deleteById(1);
        assertTrue(result);
    }
    @Test
    void update() {
        Integer id=1;
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
        doReturn(Optional.of(aula)).when(aulaJpaRepository).findById(any(Integer.class));
        when(aulaJpaRepository.findById(any(Integer.class))).thenReturn(Optional.of(aula));
        when(aulaJpaRepository.save(any(Aula.class))).thenReturn(aula);
        Aula aulaResponse = aulaService.update(1, aulaRequest);
        assertNotNull(aulaResponse);
        assertEquals(aulaResponse, aula);
    }
}
