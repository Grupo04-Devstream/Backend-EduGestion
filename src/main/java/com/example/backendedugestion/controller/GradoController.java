package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.GradoRequest;
import com.example.backendedugestion.repository.model.Grado;
import com.example.backendedugestion.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/grados")
@CrossOrigin(origins = "http://localhost:4200")
public class GradoController {

    @Autowired
    private GradoService gradoService;
    @GetMapping
    public ResponseEntity<List<Grado>> findAll() {
        return ResponseEntity.ok(gradoService.findAll());
    }
    @PostMapping
    public ResponseEntity<Grado> save(@RequestBody GradoRequest gradoRequest){
        return ResponseEntity.ok(gradoService.save(gradoRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(gradoService.deleteById(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Grado> findById(@PathVariable Integer id){
        return ResponseEntity.ok(gradoService.findById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Grado> update(@PathVariable Integer id, @RequestBody GradoRequest gradoRequest){
        return ResponseEntity.ok(gradoService.update(id,gradoRequest));
    }
}
