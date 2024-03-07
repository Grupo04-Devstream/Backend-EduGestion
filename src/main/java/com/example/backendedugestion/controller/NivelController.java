package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.NivelRequest;
import com.example.backendedugestion.repository.model.Nivele;
import com.example.backendedugestion.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @GetMapping("/nivel")
    public ResponseEntity<List<Nivele>> findAll() {
        return ResponseEntity.ok(nivelService.findAll());
    }

    @PostMapping("/nivel")
    public ResponseEntity<Nivele> save(@RequestBody NivelRequest nivelRequest) {
        return ResponseEntity.ok(nivelService.save(nivelRequest));
    }

    @GetMapping("/nivel/{id}")
    public ResponseEntity<Nivele> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(nivelService.findById(id));
    }

    @DeleteMapping("/nivel/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(nivelService.deleteById(id));
    }

    @PutMapping("/nivel/{id}")
    public ResponseEntity<Nivele> update(@PathVariable Integer id, @RequestBody NivelRequest nivelRequest) {
        return ResponseEntity.ok(nivelService.update(id, nivelRequest));
    }
}
