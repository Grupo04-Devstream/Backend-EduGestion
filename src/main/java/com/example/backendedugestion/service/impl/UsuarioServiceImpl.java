package com.example.backendedugestion.service.impl;

import com.example.backendedugestion.controller.request.UsuarioRequest;
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
    public Usuario save(UsuarioRequest usuario) {
        return usuarioJpaRepository.save(toEntity(usuario));
    }

    @Override
    public Usuario findByEmail(String email) {
        return null;
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioJpaRepository.findById(id).orElse(null);
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

    private Usuario toEntity(UsuarioRequest usuarioRequest) {
        return Usuario.builder()
                .nombre(usuarioRequest.getNombre())
                .apellido(usuarioRequest.getApellido())
                .email(usuarioRequest.getEmail())
                .password(usuarioRequest.getPassword())
                .idRol(usuarioRequest.getRol())
                .fechaNacimiento(usuarioRequest.getFechaNacimiento())
                .build();
    }
}
