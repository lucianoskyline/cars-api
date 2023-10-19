package com.carsapi.service;

import com.carsapi.model.Marca;
import com.carsapi.model.Modelo;
import com.carsapi.repository.ModeloRepository;
import com.carsapi.request.MarcaCreateRequest;
import com.carsapi.request.ModeloCreateRequest;
import com.carsapi.response.ModeloCreateResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaService marcaService;

    public ModeloCreateResponse create(ModeloCreateRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        Modelo modelo = modelMapper.map(request, Modelo.class);
        modelo.setMarca(modelMapper.map(marcaService.select(request.getMarca().getId()), Marca.class));
        modelo = modeloRepository.save(modelo);
        return convertToResponse(modelo);
    }

    public ModeloCreateResponse update(ModeloCreateRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        try {
            Modelo modelo = modeloRepository.findById(request.getId()).orElseThrow();
            modelo = modelMapper.map(request, Modelo.class);
            modelo.setMarca(modelMapper.map(marcaService.select(request.getMarca().getId()), Marca.class));

            modelo = modeloRepository.save(modelo);
            return convertToResponse(modelo);
        } catch (Exception ex) {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }

    public ModeloCreateResponse select(Integer id) {
        try {
            Modelo modelo = modeloRepository.findById(id).orElseThrow();
            return convertToResponse(modelo);
        } catch (Exception ex) {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }

    public void delete(Integer id) {
        try {
            Modelo modelo = modeloRepository.findById(id).orElseThrow();
            modeloRepository.delete(modelo);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao remover cadastro");
        }
    }

    public List<ModeloCreateResponse> findAll() {
        List<Modelo> modelos = modeloRepository.findAll();
        List<ModeloCreateResponse> response = new ArrayList<>();
        modelos.forEach(m -> response.add(convertToResponse(m)));
        return response;
    }

    public ModeloCreateResponse convertToResponse(Modelo modelo) {
        ModelMapper modelMapper = new ModelMapper();
        ModeloCreateResponse response= modelMapper.map(modelo, ModeloCreateResponse.class);
       // response.setMarca(marcaService.select(m));
        return response;
    }

}
