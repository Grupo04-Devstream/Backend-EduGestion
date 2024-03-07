package com.example.backendedugestion.service;

import com.example.backendedugestion.repository.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Usuario findByUsername(String username);
    Usuario findByEmail(String email);
    Usuario findByUsernameAndPassword(String username, String password);
    Usuario findByEmailAndPassword(String email, String password);
    List<Usuario> findAll();
    void deleteById(Integer id);
    Usuario update(Integer id);
}
