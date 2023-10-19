package com.carsapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "carro")
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampCadastro;

    @ManyToOne
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    @Column(name = "modelo_id")
    private Modelo modelo;

    private Integer ano;

    private String combustivel;

    private Integer numPortas;

    private String cor;

}
