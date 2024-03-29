package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.UsuarioRequest;
import com.example.backendedugestion.repository.model.Persona;
import com.example.backendedugestion.repository.model.Usuario;
import com.example.backendedugestion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> findAll(@RequestParam(required = false) String mail) {
        if (mail != null) {
            return ResponseEntity.ok(List.of(usuarioService.findByEmail(mail)));
        }
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> save(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(usuarioService.save(usuarioRequest));
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.deleteById(id));
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(usuarioService.update(id, usuarioRequest));
    }


}
