package com.carsapi.controller;

import com.carsapi.exception.ExceptionResponse;
import com.carsapi.request.MarcaCreateRequest;
import com.carsapi.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(marcaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity select(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(marcaService.select(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody MarcaCreateRequest request) {
        try {
            return ResponseEntity.ok(marcaService.create(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody MarcaCreateRequest request) {
        try {
            return ResponseEntity.ok(marcaService.update(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@Valid @RequestBody MarcaCreateRequest request) {
        try {
            marcaService.delete(request.getId());
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

}
