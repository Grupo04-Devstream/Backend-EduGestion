package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.AulaRequest;
import com.example.backendedugestion.repository.model.Aula;
import com.example.backendedugestion.service.AulaService;
import com.example.backendedugestion.service.impl.AulaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aula")
@CrossOrigin(origins = "http://localhost:4200")
public class AulaController {
    @Autowired
    private AulaService aulaService;
    @GetMapping
    public ResponseEntity<List<Aula>> findAll() {
        return ResponseEntity.ok(aulaService.findAll());
    }
    @PostMapping
    public ResponseEntity<Aula> save(@RequestBody AulaRequest aulaRequest){
        return ResponseEntity.ok(aulaService.save(aulaRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(aulaService.deleteById(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aula> findById(@PathVariable Integer id){
        return ResponseEntity.ok(aulaService.findById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Aula> update(@PathVariable Integer id, @RequestBody AulaRequest aulaRequest){
        return ResponseEntity.ok(aulaService.update(id,aulaRequest));
    }
}
