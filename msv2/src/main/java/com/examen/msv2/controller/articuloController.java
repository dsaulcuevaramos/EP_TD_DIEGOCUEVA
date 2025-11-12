package com.examen.msv2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.msv2.config.mapper;
import com.examen.msv2.entity.articulo;
import com.examen.msv2.service.articuloService;


@RestController
public class articuloController {

    @Autowired
    @Qualifier("articuloService")
    private articuloService ArticuloService;

    private final Logger logger = LoggerFactory.getLogger(articuloController.class);
 
    
    @PostMapping(mapper.Articulo.CREATE)
    public ResponseEntity<?> crearCliente(@RequestBody articulo Articulo) {
        try {
            articulo nuevo = ArticuloService.crear(Articulo);
            logger.info("Cliente creado exitosamente con ID {}", nuevo.getId_cliente());
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            logger.error("Error al crear cliente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error al crear cliente");
        }
    }

}
