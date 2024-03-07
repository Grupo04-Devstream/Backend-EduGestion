package com.example.backendedugestion.controller.request;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class RoleRequest {
    private String nombre;
    private String descripcion;

}
