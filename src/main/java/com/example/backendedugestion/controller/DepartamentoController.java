package com.example.backendedugestion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendedugestion.repository.model.Departamento;
import com.example.backendedugestion.service.DepartamentoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/departamento")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping()
    public ResponseEntity<List<Departamento>> findAll(){
        return ResponseEntity.ok(departamentoService.findAll());
    }

    @GetMapping("/{id}")
    public Optional<Departamento> findById(@PathVariable("id") Integer id) {
        return departamentoService.findById(id);
    }

    @PostMapping()    
    public Departamento save(@RequestBody Departamento departamento){
        return this.departamentoService.save(departamento);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return departamentoService.deleteById(id);
    }
}
