package com.carsapi.controller;

import com.carsapi.exception.ExceptionResponse;
import com.carsapi.request.ModeloCreateRequest;
import com.carsapi.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(modeloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity select(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(modeloService.select(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ModeloCreateRequest request) {
        try {
            return ResponseEntity.ok(modeloService.create(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody ModeloCreateRequest request) {
        try {
            return ResponseEntity.ok(modeloService.update(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@Valid @RequestBody ModeloCreateRequest request) {
        try {
            modeloService.delete(request.getId());
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

}
