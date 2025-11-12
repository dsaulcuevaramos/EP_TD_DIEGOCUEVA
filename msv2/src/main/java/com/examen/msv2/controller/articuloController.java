package com.examen.msv2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
 
    @GetMapping(mapper.Articulo.GET_ALL)
    public ResponseEntity<?> getAll() {
        try {
            List<articulo> articulos = ArticuloService.obtener();
            logger.info("articulos obtenidos exitosamente, total: {}", articulos.size());
            return ResponseEntity.ok(articulos);
        } catch (Exception ex) {
            logger.error("Error al obtener articulos: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al obtener articulos");
        }
    }
    
    
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
