package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.UsuarioRequest;
import com.example.backendedugestion.repository.model.Usuario;
import com.example.backendedugestion.service.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = Usuario.builder()
                .id(1)
                .nombre("nombre")
                .fechaNacimiento(LocalDate.parse("2004-04-04"))
                .apellido("apellido")
                .email("email")
                .password("password")
                .build();
    }

    @Test
    void findAll() throws Exception {
        List<Usuario> usuarios = List.of(usuario);
        when(usuarioService.findAll()).thenReturn(usuarios);

        mockMvc.perform(get("/api/v1/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("nombre"))
                .andExpect(jsonPath("$[0].fechaNacimiento").value("2004-04-04"))
                .andExpect(jsonPath("$[0].apellido").value("apellido"))
                .andExpect(jsonPath("$[0].email").value("email"));
    }

    @Test
    void save() throws Exception {
        UsuarioRequest usuarioRequest = UsuarioRequest.builder()
                .nombre("nombre")
                .apellido("apellido")
                .fechaNacimiento(LocalDate.parse("2004-04-04"))
                .email("email")
                .password("password")
                .idRol(1)
                .build();
        when(usuarioService.save(any(UsuarioRequest.class))).thenReturn(usuario);

        mockMvc.perform(post("/api/v1/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuarioRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("nombre"))
                .andExpect(jsonPath("$.fechaNacimiento").value("2004-04-04"))
                .andExpect(jsonPath("$.apellido").value("apellido"))
                .andExpect(jsonPath("$.email").value("email"));
    }

    @Test
    void findById() throws Exception {
        when(usuarioService.findById(any(Integer.class))).thenReturn(usuario);

        mockMvc.perform(get("/api/v1/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("nombre"))
                .andExpect(jsonPath("$.fechaNacimiento").value("2004-04-04"))
                .andExpect(jsonPath("$.apellido").value("apellido"))
                .andExpect(jsonPath("$.email").value("email"));
    }

    @Test
    void deleteById() throws Exception {
        when(usuarioService.deleteById(1)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    void update() throws Exception {
        when(usuarioService.update(any(Integer.class), any(UsuarioRequest.class))).thenReturn(usuario);

        mockMvc.perform(put("/api/v1/usuarios/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(UsuarioRequest.builder()
                        .nombre("nombre")
                        .apellido("apellido")
                        .fechaNacimiento(LocalDate.parse("2004-04-04"))
                        .email("email")
                        .password("password")
                        .idRol(1)
                        .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("nombre"))
                .andExpect(jsonPath("$.fechaNacimiento").value("2004-04-04"))
                .andExpect(jsonPath("$.apellido").value("apellido"))
                .andExpect(jsonPath("$.email").value("email"));
    }
}