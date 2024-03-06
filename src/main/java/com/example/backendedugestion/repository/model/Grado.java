package com.example.backendedugestion.repository.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nro_grado")
    private int nroGrado;

    @ManyToOne
    @JoinColumn(name = "id_nivel")
    private Nivel nivel;
}
