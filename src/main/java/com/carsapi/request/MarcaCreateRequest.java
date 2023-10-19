package com.carsapi.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class MarcaCreateRequest {

    private Integer id;

    @NotEmpty(message = "Informe o nome")
    private String nomeMarca;

}
