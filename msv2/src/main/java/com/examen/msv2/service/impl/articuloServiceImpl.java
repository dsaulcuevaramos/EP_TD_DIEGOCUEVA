package com.examen.msv2.service.impl;
import com.examen.msv2.entity.articulo;
import com.examen.msv2.repository.articuloRepository;
import com.examen.msv2.service.articuloService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("articuloService")
public class articuloServiceImpl implements articuloService{
    
    @Autowired
    @Qualifier("articuloRepository")
    private articuloRepository ArticuloRepository;

    public final Logger logger = LoggerFactory.getLogger(articuloServiceImpl.class);
    

    @Override
    public articulo crear(articulo articulo) {
        return ArticuloRepository.save(articulo);
    }

    @Override
    public List<articulo> obtener() {
        try {
            return ArticuloRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al obtener los usuarios: " + e.getMessage(), e);
            throw e;
        }
    }

}
