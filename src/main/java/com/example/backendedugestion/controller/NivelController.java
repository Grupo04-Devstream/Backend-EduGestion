package com.example.backendedugestion.controller;

import com.example.backendedugestion.controller.request.NivelRequest;
import com.example.backendedugestion.controller.wrapper.WrapperGenericoObjetos;
import com.example.backendedugestion.repository.model.Nivele;
import com.example.backendedugestion.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/nivel")
@CrossOrigin(origins = "http://localhost:4200")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @GetMapping()
    public ResponseEntity<List<Nivele>> findAll() {
        return ResponseEntity.ok(nivelService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Nivele> save(@RequestBody NivelRequest nivelRequest) {
        return ResponseEntity.ok(nivelService.save(nivelRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nivele> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(nivelService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<WrapperGenericoObjetos<Nivele>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(WrapperGenericoObjetos.<Nivele>builder()
                .datos(nivelService.delete(id))
                .build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<WrapperGenericoObjetos<Nivele>> update(
            @RequestBody WrapperGenericoObjetos<Nivele> niveleRequest
    ) {
        return ResponseEntity.ok(WrapperGenericoObjetos.<Nivele>builder()
                .datos(nivelService.update(niveleRequest.getDatos()))
                .build());
    }
}
