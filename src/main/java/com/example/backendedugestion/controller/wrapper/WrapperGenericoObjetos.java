package com.example.backendedugestion.controller.wrapper;

import jakarta.validation.Valid;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WrapperGenericoObjetos<T> implements Serializable {

    @Valid
    private transient T datos;
}