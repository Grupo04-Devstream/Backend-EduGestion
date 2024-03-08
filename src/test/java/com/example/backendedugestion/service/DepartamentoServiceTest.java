package com.example.backendedugestion.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.backendedugestion.repository.DepartamentoJpaRepository;
import com.example.backendedugestion.repository.model.Departamento;
import com.example.backendedugestion.service.impl.DepartamentoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {

    @Mock
    private DepartamentoJpaRepository departamentoJpaRepository;

    @InjectMocks
    private DepartamentoServiceImpl departamentoService;

    private Departamento departamento;

    @BeforeEach
    void setUp(){
        departamento = Departamento.builder()
                .id(1)
                .nombre("Administración")
                .descripcion("Manejo de las actividades")
                .build();
    }

    @Test
    void save() {
        when(departamentoJpaRepository.save(any(Departamento.class))).thenReturn(departamento);
        Departamento result= departamentoService.save(departamento);
        assertNotNull(result);
        assertEquals(departamento.getNombre(), result.getNombre());
    }

    @Test
    void findById() {
        when(departamentoJpaRepository.findById(1)).thenReturn(Optional.of(departamento));

        Optional<Departamento> foundDepartamento = departamentoService.findById(1);

        assertTrue(foundDepartamento.isPresent());
        assertEquals(departamento, foundDepartamento.get());
    }

    @Test
    void findAll() {
        when(departamentoJpaRepository.findAll()).thenReturn(List.of(departamento));
        
        List<Departamento> result = departamentoService.findAll();
        assertFalse(result.isEmpty());
        assertEquals(departamento, result.get(0));
    }

    @Test
    void deleteById() {
        when(departamentoJpaRepository.findById(1)).thenReturn(Optional.of(departamento));
        boolean result = departamentoService.deleteById(1);
        assertTrue(result);
    }

    @Test
    void update() {
        when(departamentoJpaRepository.save(departamento)).thenReturn(departamento);

        Departamento updatedDepartamento = departamentoService.Update(departamento);

        assertNotNull(updatedDepartamento);
        assertEquals(departamento, updatedDepartamento);
    }
}