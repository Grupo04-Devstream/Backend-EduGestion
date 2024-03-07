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
@Table(name = "aulas")
@NoArgsConstructor
@AllArgsConstructor
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "descripcion", length = 30)
    private String descripcion;

    @Column(name = "piso")
    private Integer piso;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "pabellon")
    private Integer pabellon;

    @OneToOne(mappedBy = "idAula")
    private Seccione secciones;

}