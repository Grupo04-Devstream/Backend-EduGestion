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
@Table(name = "niveles")
@NoArgsConstructor
@AllArgsConstructor
public class Nivele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @OneToMany(mappedBy = "idNivel")
    private Set<Grado> grados = new LinkedHashSet<>();

}