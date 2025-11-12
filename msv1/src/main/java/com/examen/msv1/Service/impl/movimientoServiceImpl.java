package com.examen.msv1.Service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.examen.msv1.Repository.movimientoRepository;
import com.examen.msv1.Service.movimientoService;
import com.examen.msv1.entity.movimiento;

@Service("movimientoService")
public class movimientoServiceImpl implements movimientoService {

    @Autowired
    @Qualifier("movimientoRepository")
    private movimientoRepository MovimientoRepository;

    public final Logger logger = LoggerFactory.getLogger(movimientoServiceImpl.class);
    

    @Override
    public List<movimiento> obtener() {
        try {
            return MovimientoRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al obtener los usuarios: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public movimiento guardarMovimiento(movimiento Movimiento) {
        try {
            return MovimientoRepository.save(Movimiento);
        } catch (Exception e) {
            logger.error("Error al guardar el usuario: " + e.getMessage(), e);
            throw e;
        }
    }
}
