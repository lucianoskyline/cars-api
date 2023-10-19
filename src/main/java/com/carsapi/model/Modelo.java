package com.carsapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "modelo")
@Data
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    private Marca marca;

    private String nome;

    private Double valorFipe;

}
