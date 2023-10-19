package com.carsapi.service;

import com.carsapi.model.Carro;
import com.carsapi.model.Modelo;
import com.carsapi.repository.CarroRepository;
import com.carsapi.request.CarroCreateRequest;
import com.carsapi.response.CarroCreateResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloService modeloService;

    public CarroCreateResponse create(CarroCreateRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        Carro carro = modelMapper.map(request, Carro.class);
        carro.setTimestampCadastro(new Date());
        carro.setModelo(modelMapper.map(modeloService.select(request.getModelo().getId()), Modelo.class));
        carro = carroRepository.save(carro);
        return convertToResponse(carro);
    }

    public CarroCreateResponse update(CarroCreateRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        try {
            Carro carro = carroRepository.findById(request.getId()).orElseThrow();
            carro = modelMapper.map(request, Carro.class);
            carro.setModelo(modelMapper.map(modeloService.select(request.getModelo().getId()), Modelo.class));

            carro = carroRepository.save(carro);
            return convertToResponse(carro);
        } catch (Exception ex) {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }

    public CarroCreateResponse select(Integer id) {
        try {
            Carro carro = carroRepository.findById(id).orElseThrow();
            return convertToResponse(carro);
        } catch (Exception ex) {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }

    public void delete(Integer id) {
        try {
            Carro carro = carroRepository.findById(id).orElseThrow();
            carroRepository.delete(carro);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao remover cadastro");
        }
    }

    public List<CarroCreateResponse> findAll() {
        List<Carro> carros = carroRepository.findAll();
        List<CarroCreateResponse> response = new ArrayList<>();
        carros.forEach(m -> response.add(convertToResponse(m)));
        return response;
    }

    public CarroCreateResponse convertToResponse(Carro carro) {
        ModelMapper modelMapper = new ModelMapper();
        CarroCreateResponse response= modelMapper.map(carro, CarroCreateResponse.class);
        return response;
    }

}
