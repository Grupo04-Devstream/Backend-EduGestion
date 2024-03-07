package com.example.backendedugestion.service.impl;

import com.example.backendedugestion.repository.UsuarioJpaRepository;
import com.example.backendedugestion.repository.model.Usuario;
import com.example.backendedugestion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioJpaRepository.save(usuario);
    }

    @Override
    public Usuario findByUsername(String username) {

        //return usuarioJpaRepository.findByUsername(username);
        return null;
    }

    @Override
    public Usuario findByEmail(String email) {
        return null;
    }

    @Override
    public Usuario findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public Usuario findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioJpaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        usuarioJpaRepository.deleteById(id);
    }

    @Override
    public Usuario update(Integer id) {
        return null;
    }
}
