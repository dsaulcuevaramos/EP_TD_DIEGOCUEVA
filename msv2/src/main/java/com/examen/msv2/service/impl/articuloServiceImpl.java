package com.examen.msv2.service.impl;
import com.examen.msv2.entity.articulo;
import com.examen.msv2.repository.articuloRepository;
import com.examen.msv2.service.articuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("articuloService")
public class articuloServiceImpl implements articuloService{
    
    @Autowired
    @Qualifier("articuloRepository")
    private articuloRepository ArticuloRepository;

    @Override
    public articulo crear(articulo articulo) {
        return ArticuloRepository.save(articulo);
    }

}
