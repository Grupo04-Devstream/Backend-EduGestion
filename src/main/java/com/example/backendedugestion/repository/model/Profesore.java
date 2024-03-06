package com.example.backendedugestion.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "profesores")
@NoArgsConstructor
@AllArgsConstructor
public class Profesore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trabajador")
    private Trabajadore idTrabajador;

    @Column(name = "especialidad", length = 30)
    private String especialidad;

    @OneToMany(mappedBy = "idProfesor")
    private Set<CursoSeccion> cursoSeccions = new LinkedHashSet<>();

}