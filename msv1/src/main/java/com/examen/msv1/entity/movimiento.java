package com.examen.msv1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movimiento")
public class movimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimiento")
    private int idMovimiento;

    @Column(name = "idArticulo")
    private int idArticulo;

    @Column(name = "tipoMovimiento")
    private String tipoMovimiento;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "estado")
    private int estado;

}
