package com.example.backendedugestion.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "niveles")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nivele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @OneToMany(mappedBy = "idNivel")
    private List<Grado> grados;

}