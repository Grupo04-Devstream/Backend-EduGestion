package com.example.backendedugestion.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
@Getter
@Setter
public class CursoSeccionId implements Serializable {
    private static final long serialVersionUID = -5406357694239017052L;

    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    @Column(name = "id_seccion", nullable = false)
    private Integer idSeccion;


}