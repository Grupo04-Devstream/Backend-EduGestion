package com.example.backendedugestion.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @Column(name = "nrohoras")
    private Short nrohoras;

    @OneToMany(mappedBy = "curso")
    private List<CursoSeccion> cursoSeccion;

    @OneToMany(mappedBy = "idCurso")
    private Set<Nota> notas = new LinkedHashSet<>();

}