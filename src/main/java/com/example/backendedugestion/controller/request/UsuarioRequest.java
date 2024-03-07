package com.example.backendedugestion.controller.request;

import com.example.backendedugestion.repository.model.Alumno;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.repository.model.Trabajadore;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Getter
public class UsuarioRequest {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;
    private String password;
    private Role rol;
}
