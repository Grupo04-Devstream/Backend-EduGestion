package com.example.backendedugestion.repository;

import com.example.backendedugestion.repository.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoJpaRepository extends JpaRepository<TipoDocumento, Long> {
}
