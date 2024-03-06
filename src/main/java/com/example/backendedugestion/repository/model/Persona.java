package com.example.backendedugestion.repository.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persona")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nombre;
  private String apellido;

  @ManyToOne
  @JoinColumn(name = "tipo_documento_id")
  private TipoDocumento tipoDocumento;

  private String numeroDocumento;
}
