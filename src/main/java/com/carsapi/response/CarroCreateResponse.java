package com.carsapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class CarroCreateResponse {

    private Integer id;

    private ModeloCreateResponse modelo;

    private Integer ano;

    private String combustivel;

    private Integer numPortas;

    private String cor;

}
