package com.example.backendedugestion.controller.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AulaRequest {
    private String descripcion;
    private Integer piso;
    private Integer capacidad;
    private Integer pabellon;
}
