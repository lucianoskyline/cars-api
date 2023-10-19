package com.carsapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "marca")
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeMarca;

}
