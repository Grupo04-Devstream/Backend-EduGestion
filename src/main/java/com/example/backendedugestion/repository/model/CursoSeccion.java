package com.example.backendedugestion.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso_seccion")
@NoArgsConstructor
@AllArgsConstructor
public class CursoSeccion {

    @EmbeddedId
    private CursoSeccionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesore idProfesor;

    @ManyToOne
    @JoinColumn(name="id_curso",insertable = false, updatable = false)
    @MapsId("idCurso")
    private Curso curso;




}