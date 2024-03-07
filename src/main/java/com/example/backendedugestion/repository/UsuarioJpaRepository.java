package com.example.backendedugestion.repository;

import com.example.backendedugestion.repository.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario,Integer> {
}
