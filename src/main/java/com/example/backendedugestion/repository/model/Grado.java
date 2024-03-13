package com.example.backendedugestion.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "grados")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "id_nivel")
    private Nivele idNivel;

    @Column(name = "gradonro")
    private Integer gradonro;

}