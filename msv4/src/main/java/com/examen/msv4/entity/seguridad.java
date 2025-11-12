package com.examen.msv4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "seguridad")
public class seguridad {

    @Id
    private String idUsuario;

    private String nombre;
    @Indexed(unique = true)
    private String clave;


}
