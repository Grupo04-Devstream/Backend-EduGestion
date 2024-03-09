package com.example.backendedugestion.service.impl;

import com.example.backendedugestion.controller.request.RoleRequest;
import com.example.backendedugestion.repository.RoleJpaRepository;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.service.RoleService;
import com.example.backendedugestion.service.exception.NotFoundTipoDocumentoException;
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
    public Role update(Role roleRequest) {
        Role nivele = roleJpaRepository.findById(roleRequest.getId()).orElse(null);
        if(nivele == null){
            throw new NotFoundTipoDocumentoException("El tipo de documento no existe");
        }
        nivele.setNombre(roleRequest.getNombre());
        return roleJpaRepository.save(nivele);
    }

    @Override
    public Role delete(Integer id) {
        Role nivele = roleJpaRepository.findById(id).orElse(null);
        if(nivele == null){
            throw new NotFoundTipoDocumentoException("El tipo de documento no existe");
        }
        roleJpaRepository.delete(nivele);
        return nivele;
    }

    private Role toEntity(RoleRequest roleRequest) {
        return Role.builder()
                .nombre(roleRequest.getNombre())
                .descripcion(roleRequest.getDescripcion())
                .build();
    }

}
