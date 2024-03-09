package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.RoleRequest;
import com.example.backendedugestion.repository.RoleJpaRepository;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.service.exception.NotFoundTipoDocumentoException;
import com.example.backendedugestion.service.impl.RoleServiceImpl;
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
class RoleServiceImplTest {
    @Mock
    private RoleJpaRepository rolJpaRepository;

    @InjectMocks
    private RoleServiceImpl rolService;

    private Role role;

    @BeforeEach
    void setUp(){
        role = Role.builder()
                .id(900)
                .nombre("Estudiante")
                .descripcion("Estudiante de la Institucion")
                .build();
    }

    @Test
    void save() {
        RoleRequest rolRequest =RoleRequest.builder()
                .nombre("Estudiante")
                .descripcion("Estudiante de la Institucion")
                .build();

        when(rolJpaRepository.save(any(Role.class))).thenReturn(role);
        Role result= rolService.save(rolRequest);
        assertNotNull(result);
        assertEquals(role.getNombre(), result.getNombre());
    }

    @Test
    void findById() {
        when(rolJpaRepository.findById(900)).thenReturn(Optional.of(role));
        Role result = rolService.findById(900);
        assertNotNull(result);
        assertEquals(role.getId(), result.getId());
    }

    @Test
    void findAll() {
        when(rolJpaRepository.findAll()).thenReturn(List.of(role));
        assertNotNull(rolService.findAll());
    }

    @Test
    void deleteById() {
        when(rolJpaRepository.findById(900)).thenReturn(Optional.of(role));
        doNothing().when(rolJpaRepository).delete(role);
        Role result = rolService.delete(900);
        assertNotNull(result);
        assertEquals(role.getId(), result.getId());
    }
    @Test
    void deleteNivelNotFoundTest() {
        when(rolJpaRepository.findById(900)).thenReturn(Optional.empty());
        assertThrows(NotFoundTipoDocumentoException.class, () -> rolService.delete(900));
    }

    @Test
    void update() {
        when(rolJpaRepository.findById(900)).thenReturn(Optional.of(role));
        when(rolJpaRepository.save(any(Role.class))).thenReturn(role);
        Role updated = Role.builder()
                .id(900)
                .nombre("Estudiante")
                .descripcion("Estudiante de la Institucion")
                .build();
        Role result = rolService.update(updated);
        assertNotNull(result);
        assertEquals(updated.getNombre(), result.getNombre());

    }
}