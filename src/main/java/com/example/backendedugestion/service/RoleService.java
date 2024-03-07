package com.example.backendedugestion.service;

import com.example.backendedugestion.controller.request.RoleRequest;
import com.example.backendedugestion.repository.model.Role;

import java.util.List;

public interface RoleService {
    Role save(RoleRequest roleRequest);
    Role findById(Integer id);
    List<Role> findAll();
    boolean deleteById(Integer id);
    Role update(Integer id, RoleRequest roleRequest);
}
