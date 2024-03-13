package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.RoleRequest;
import com.example.backendedugestion.controller.wrapper.WrapperGenericoObjetos;
import com.example.backendedugestion.repository.model.Role;
import com.example.backendedugestion.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<WrapperGenericoObjetos<Role>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(WrapperGenericoObjetos.<Role>builder()
                .datos(roleService.delete(id))
                .build());
    }

    @PutMapping("/rol/{id}")
    public ResponseEntity<WrapperGenericoObjetos<Role>> update(
            @RequestBody WrapperGenericoObjetos<Role> roleRequest
    ) {
        return ResponseEntity.ok(WrapperGenericoObjetos.<Role>builder()
                .datos(roleService.update(roleRequest.getDatos()))
                .build());
    }
}