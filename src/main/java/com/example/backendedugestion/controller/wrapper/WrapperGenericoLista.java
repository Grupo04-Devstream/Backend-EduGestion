package com.example.backendedugestion.controller.wrapper;

import jakarta.validation.Valid;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WrapperGenericoLista<T> implements Serializable {

    @Valid
    private transient List<T> datos;
}