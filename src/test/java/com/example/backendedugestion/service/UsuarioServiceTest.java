package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.UsuarioRequest;
import com.example.backendedugestion.repository.RoleJpaRepository;
import com.example.backendedugestion.repository.UsuarioJpaRepository;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.repository.model.Usuario;
import com.example.backendedugestion.service.impl.UsuarioServiceImpl;
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
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioJpaRepository usuarioJpaRepository;
    @Mock
    private RoleJpaRepository roleJpaRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = Usuario.builder()
                .id(1)
                .nombre("nombre")
                .apellido("apellido")
                .email("email")
                .password("password")
                .build();
    }

    @Test
    void save() {
        UsuarioRequest usuarioRequest = UsuarioRequest.builder()
                .nombre("nombre")
                .apellido("apellido")
                .email("email")
                .password("password")
                .idRol(1)
                .build();
        Role role = Role.builder()
                .id(1)
                .nombre("nombre")
                .build();
        doReturn(Optional.of(role)).when(roleJpaRepository).findById(any(Integer.class));
        when(usuarioJpaRepository.save(any(Usuario.class))).thenReturn(usuario);
        Usuario usuarioResponse = usuarioService.save(usuarioRequest);
        assertNotNull(usuarioResponse);
        assertEquals(usuarioResponse, usuario);
    }

    @Test
    void findByEmail() {
        when(usuarioJpaRepository.findByEmail(any(String.class))).thenReturn(usuario);
        Usuario usuarioResponse = usuarioService.findByEmail("email");
        assertNotNull(usuarioResponse);
        assertEquals(usuarioResponse, usuario);
    }

    @Test
    void findById() {
        when(usuarioJpaRepository.findById(any(Integer.class))).thenReturn(Optional.of(usuario));
        Usuario usuarioResponse = usuarioService.findById(1);
        assertNotNull(usuarioResponse);
        assertEquals(usuarioResponse, usuario);
    }

    @Test
    void findByEmailAndPassword() {
    }

    @Test
    void findAll() {
        when(usuarioJpaRepository.findAll()).thenReturn(List.of(usuario));
        List<Usuario> usuarios = usuarioService.findAll();
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        assertEquals(usuarios.size(), 1);
    }

    @Test
    void deleteById() {
        assertTrue(usuarioService.deleteById(1));
    }

    @Test
    void update() {
        UsuarioRequest usuarioRequest = UsuarioRequest.builder()
                .nombre("nombre")
                .apellido("apellido")
                .email("email")
                .password("password")
                .idRol(1)
                .build();
        Role role = Role.builder()
                .id(1)
                .nombre("nombre")
                .build();
        doReturn(Optional.of(role)).when(roleJpaRepository).findById(any(Integer.class));
        when(usuarioJpaRepository.findById(any(Integer.class))).thenReturn(Optional.of(usuario));
        when(usuarioJpaRepository.save(any(Usuario.class))).thenReturn(usuario);
        Usuario usuarioResponse = usuarioService.update(1, usuarioRequest);
        assertNotNull(usuarioResponse);
        assertEquals(usuarioResponse, usuario);
    }
}