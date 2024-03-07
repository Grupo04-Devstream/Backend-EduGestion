package com.example.backendedugestion.service.impl;

import com.example.backendedugestion.controller.request.RoleRequest;
import com.example.backendedugestion.repository.RoleJpaRepository;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleJpaRepository roleJpaRepository;

    @Override
    public Role save(RoleRequest roleRequest) {
        return roleJpaRepository.save(toEntity(roleRequest));
    }

    @Override
    public Role findById(Integer id) {
        return roleJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleJpaRepository.findAll();
    }
    @Override
    public boolean deleteById(Integer id) {
        roleJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public Role update(Integer id, RoleRequest roleRequest) {
        Role rol = roleJpaRepository.findById(id).orElse(null);
        if (rol == null) {
            return null;
        }
        rol.setNombre(roleRequest.getNombre());
        rol.setDescripcion(roleRequest.getDescripcion());
        return roleJpaRepository.save(rol);
    }

    private Role toEntity(RoleRequest roleRequest) {
        return Role.builder()
                .nombre(roleRequest.getNombre())
                .descripcion(roleRequest.getDescripcion())
                .build();
    }
}

