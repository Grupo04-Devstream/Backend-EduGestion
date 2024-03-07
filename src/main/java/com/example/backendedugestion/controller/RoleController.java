package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.RoleRequest;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/rol")
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping("/rol")
    public ResponseEntity<Role> save(@RequestBody RoleRequest roleRequest) {
        return ResponseEntity.ok(roleService.save(roleRequest));
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<Role> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @DeleteMapping("/rol/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(roleService.deleteById(id));
    }

    @PutMapping("/rol/{id}")
    public ResponseEntity<Role> update(@PathVariable Integer id, @RequestBody RoleRequest roleRequest) {
        return ResponseEntity.ok(roleService.update(id, roleRequest));
    }
}
