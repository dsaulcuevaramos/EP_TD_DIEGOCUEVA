package com.examen.msv3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.examen.msv3.entity.productos;
import com.examen.msv3.repository.productoRepository;
import com.examen.msv3.service.productoService;

@Service("productoService")
public class productoServiceImpl implements productoService {

    @Autowired
    @Qualifier("productoRepository")
    private productoRepository productoRepository;

    @Override
    public productos guardarProducto(productos producto) {
        return productoRepository.save(producto);
    }

    @Override
    public productos obtenerProductoPorId(int id_producto) {
        return productoRepository.findById(id_producto).orElse(null);
    }

    @Override
    public boolean eliminarProducto(int id_producto) {
        if (productoRepository.existsById(id_producto)) {
            productoRepository.deleteById(id_producto);
            return true;
        }
        return false;
    }

    @Override
    public List<productos> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

}
