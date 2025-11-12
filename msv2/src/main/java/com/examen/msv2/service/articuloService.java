package com.examen.msv2.service;

import java.util.List;

import com.examen.msv2.entity.articulo;

public interface articuloService {
    
    public articulo crear(articulo Articulo);
    public List<articulo> obtener();

}
