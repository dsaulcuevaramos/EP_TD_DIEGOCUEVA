package com.examen.msv4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "sell")
public class sell {

    @Id
    private String id;

    @Indexed(unique = true)
    private int codigo;

    private String nombre_producto;
    private int cantidad;
    private double precio_unitario;
    private double total_precio;

}

