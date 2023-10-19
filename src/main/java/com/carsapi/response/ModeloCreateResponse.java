package com.carsapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ModeloCreateResponse {

    private Integer id;

    private String nome;

    private Double valorFipe;

    private MarcaCreateResponse marca;

}
