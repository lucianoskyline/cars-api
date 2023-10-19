package com.carsapi.controller;

import com.carsapi.exception.ExceptionResponse;
import com.carsapi.request.CarroCreateRequest;
import com.carsapi.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(carroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity select(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(carroService.select(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody CarroCreateRequest request) {
        try {
            return ResponseEntity.ok(carroService.create(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody CarroCreateRequest request) {
        try {
            return ResponseEntity.ok(carroService.update(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@Valid @RequestBody CarroCreateRequest request) {
        try {
            carroService.delete(request.getId());
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

}
