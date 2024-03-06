package com.example.backendedugestion.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "nivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nivel {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Grado> grados;
}
