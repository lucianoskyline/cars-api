package com.carsapi.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ModeloCreateRequest {

    private Integer id;

    @NotEmpty(message = "Informe o nome")
    private String nome;

    @NotNull(message = "Informe o valor da FIPE")
    private Double valorFipe;

    @NotNull(message = "Informe a marca")
    private MarcaCreateRequest marca;

}
