package com.carsapi.controller;

import com.carsapi.exception.ExceptionResponse;
import com.carsapi.request.ModeloCreateRequest;
import com.carsapi.service.ModeloService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @ApiOperation(value = "Listar")
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(modeloService.findAll());
    }

    @ApiOperation(value = "Selecionar")
    @GetMapping("/{id}")
    public ResponseEntity select(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(modeloService.select(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @ApiOperation(value = "Cadastrar")
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ModeloCreateRequest request) {
        try {
            return ResponseEntity.ok(modeloService.create(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @ApiOperation(value = "Atualizar")
    @PutMapping
    public ResponseEntity update(@Valid @RequestBody ModeloCreateRequest request) {
        try {
            return ResponseEntity.ok(modeloService.update(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage()));
        }
    }

    @ApiOperation(value = "Deletar")
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
