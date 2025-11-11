package com.examen.msv3.service;

import java.util.List;

import com.examen.msv3.entity.productos;

public interface productoService {

    public productos guardarProducto(productos producto);

    public productos obtenerProductoPorId(int id_producto);

    public boolean eliminarProducto(int id_producto);

    public List<productos> obtenerTodosLosProductos();

}
