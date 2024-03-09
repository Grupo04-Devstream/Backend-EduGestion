package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.NivelRequest;
import com.example.backendedugestion.repository.NivelJpaRepository;
import com.example.backendedugestion.repository.model.Nivele;
import com.example.backendedugestion.service.exception.NotFoundTipoDocumentoException;
import com.example.backendedugestion.service.impl.NivelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class NivelServiceImplTest {
    @Mock
    private NivelJpaRepository nivelJpaRepository;

    @InjectMocks
    private NivelServiceImpl nivelService;

    private Nivele nivel;

    @BeforeEach
    void setUp(){
        nivel = Nivele.builder()
                .id(900)
                .nombre("Primaria")
                .build();
    }

    @Test
    void save() {
        NivelRequest nivelRequest =NivelRequest.builder()
                .nombre("Primaria")
                .build();

        when(nivelJpaRepository.save(any(Nivele.class))).thenReturn(nivel);
        Nivele result= nivelService.save(nivelRequest);
        assertNotNull(result);
        assertEquals(nivel.getNombre(), result.getNombre());
    }

    @Test
    void findById() {
        when(nivelJpaRepository.findById(900)).thenReturn(Optional.of(nivel));
        Nivele result = nivelService.findById(900);
        assertNotNull(result);
        assertEquals(nivel.getId(), result.getId());
    }

    @Test
    void findAll() {
        when(nivelJpaRepository.findAll()).thenReturn(List.of(nivel));
        assertNotNull(nivelService.findAll());
    }

    @Test
    void deleteById() {
        when(nivelJpaRepository.findById(900)).thenReturn(Optional.of(nivel));
        doNothing().when(nivelJpaRepository).delete(nivel);
        Nivele result = nivelService.delete(900);
        assertNotNull(result);
        assertEquals(nivel.getId(), result.getId());
    }
    @Test
    void deleteRolNotFoundTest() {
        when(nivelJpaRepository.findById(900)).thenReturn(Optional.empty());
        assertThrows(NotFoundTipoDocumentoException.class, () -> nivelService.delete(900));
    }

    @Test
    void update() {
        when(nivelJpaRepository.findById(900)).thenReturn(Optional.of(nivel));
        when(nivelJpaRepository.save(any(Nivele.class))).thenReturn(nivel);
        Nivele updated = Nivele.builder()
                .id(900)
                .nombre("Primaria")
                .build();
        Nivele result = nivelService.update(updated);
        assertNotNull(result);
        assertEquals(updated.getNombre(), result.getNombre());

    }


}