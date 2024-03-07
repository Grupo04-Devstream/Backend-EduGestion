package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.UsuarioRequest;
import com.example.backendedugestion.repository.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(UsuarioRequest usuario);
    Usuario findByEmail(String email);
    Usuario findById(Integer id);
    Usuario findByEmailAndPassword(String email, String password);
    List<Usuario> findAll();
    void deleteById(Integer id);
    Usuario update(Integer id);
}
