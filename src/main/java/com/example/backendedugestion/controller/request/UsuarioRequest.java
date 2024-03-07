package com.example.backendedugestion.controller.request;

import com.example.backendedugestion.repository.model.Alumno;
import com.example.backendedugestion.repository.model.Trabajadore;

import java.time.LocalDate;
import java.util.Set;

public class UsuarioRequest {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String password;
    private Set<Alumno> alumnos;
    private Set<Trabajadore> trabajadores;
}
