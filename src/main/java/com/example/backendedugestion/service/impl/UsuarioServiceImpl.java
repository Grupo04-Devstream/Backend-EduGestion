package com.example.backendedugestion.service.impl;

import com.example.backendedugestion.controller.request.UsuarioRequest;
import com.example.backendedugestion.repository.RoleJpaRepository;
import com.example.backendedugestion.repository.UsuarioJpaRepository;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.repository.model.Usuario;
import com.example.backendedugestion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Autowired
    private RoleJpaRepository roleJpaRepository;

    @Override
    public Usuario save(UsuarioRequest usuario) {
        return usuarioJpaRepository.save(toEntity(usuario));
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioJpaRepository.findByEmail(email);
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
    public boolean deleteById(Integer id) {
        usuarioJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public Usuario update(Integer id, UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioJpaRepository.findById(id).orElse(null);
        if (usuario == null) {
            return null;
        }
        Role role = roleJpaRepository.findById(usuarioRequest.getIdRol()).orElse(null);
        if (role == null) {
            return null;
        }
        usuario.setNombre(usuarioRequest.getNombre());
        usuario.setApellido(usuarioRequest.getApellido());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setIdRol(role);
        usuario.setFechaNacimiento(usuarioRequest.getFechaNacimiento());
        return usuarioJpaRepository.save(usuario);
    }

    private Usuario toEntity(UsuarioRequest usuarioRequest) {
        Role role = roleJpaRepository.findById(usuarioRequest.getIdRol()).orElse(null);
        if (role == null) {
            return null;
        }
        return Usuario.builder()
                .nombre(usuarioRequest.getNombre())
                .apellido(usuarioRequest.getApellido())
                .email(usuarioRequest.getEmail())
                .password(usuarioRequest.getPassword())
                .idRol(role)
                .fechaNacimiento(usuarioRequest.getFechaNacimiento())
                .build();
    }
}
