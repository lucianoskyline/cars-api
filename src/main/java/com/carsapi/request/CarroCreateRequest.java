package com.carsapi.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class CarroCreateRequest {

    private Integer id;

    @NotNull(message = "Informe o modelo")
    private ModeloCreateRequest modelo;

    @NotNull(message = "Informe o ano")
    private Integer ano;

    @NotBlank(message = "Informe o combustivel")
    private String combustivel;

    @NotNull(message = "Informe o número de portas")
    private Integer numPortas;

    @NotBlank(message = "Informe a cor")
    private String cor;

}
