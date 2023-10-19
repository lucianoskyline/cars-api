package com.carsapi.service;

import com.carsapi.model.Marca;
import com.carsapi.repository.MarcaRepository;
import com.carsapi.request.MarcaCreateRequest;
import com.carsapi.response.MarcaCreateResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public MarcaCreateResponse create(MarcaCreateRequest request) {
        Marca marca = new ModelMapper().map(request, Marca.class);
        marca = marcaRepository.save(marca);
        return convertToResponse(marca);
    }

    public MarcaCreateResponse update(MarcaCreateRequest request) {
        try {
            Marca marca = marcaRepository.findById(request.getId()).orElseThrow();
            marca = new ModelMapper().map(request, Marca.class);
            marca = marcaRepository.save(marca);
            return convertToResponse(marca);
        } catch (Exception ex) {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }

    public MarcaCreateResponse select(Integer id) {
        try {
            Marca marca = marcaRepository.findById(id).orElseThrow();
            return convertToResponse(marca);
        } catch (Exception ex) {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }

    public void delete(Integer id) {
        try {
            Marca marca = marcaRepository.findById(id).orElseThrow();
            marcaRepository.delete(marca);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao remover cadastro");
        }
    }

    public List<MarcaCreateResponse> findAll() {
        List<Marca> marcas = marcaRepository.findAll();
        List<MarcaCreateResponse> response = new ArrayList<>();
        marcas.forEach(m -> response.add(convertToResponse(m)));
        return response;
    }

    public MarcaCreateResponse convertToResponse(Marca marca) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(marca, MarcaCreateResponse.class);
    }

}
