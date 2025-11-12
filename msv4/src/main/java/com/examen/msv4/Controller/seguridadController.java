package com.examen.msv4.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.examen.msv4.config.mapper;
import com.examen.msv4.entity.seguridad;
import com.examen.msv4.service.seguridadService;


@RestController
public class seguridadController {
    

    @Autowired
    private seguridadService SeguridadService;

    private static final Logger logger = LoggerFactory.getLogger(seguridadController.class);

/*
    @GetMapping(mapper.Seguridad.LOGINNC)
    public ResponseEntity<?> loginByNombreClave(@PathVariable String nombre, @PathVariable String clave) {
        try {
            seguridad login = SeguridadService.loginByNombreClave(nombre, clave);
            if (login != null) {
                logger.info("usuario {} obtenido exitosamente", login);
                return ResponseEntity.ok(login);
            } else {
                logger.warn("usuario {} no encontrada", nombre);
                return ResponseEntity.status(404).body("Venta no encontrada");
            }
        } catch (Exception e) {
            logger.error("Error al obtener el usuario {}: {}", nombre, e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
*/
    @GetMapping(mapper.Seguridad.LOGIN)
    public ResponseEntity<?> login(@PathVariable String nombre, @PathVariable String clave){
        try {
            List<seguridad> nombres = SeguridadService.getByNombre(nombre);
            seguridad claves = SeguridadService.getByClave(clave);
            seguridad result = null;
                
            for(seguridad nombre_actual:nombres){
                if(nombre_actual == claves){
                    result = nombre_actual;  
                }
            }

            if(result !=null ){
                logger.info("usuarios {} obtenido exitosamente", result);
                return ResponseEntity.ok(result);
            }else {
                logger.warn("usuario {} no encontrada", nombre);
                return ResponseEntity.status(404).body("Venta no encontrada");
            }
        } catch (Exception e) {
            logger.error("Error al obtener el usuario {}: {}", nombre, e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @GetMapping(mapper.Seguridad.GET_ALL)
    public ResponseEntity<?> getAll() {
        try {
            List<seguridad> seguridads = SeguridadService.obtener();
            logger.info("seguridads obtenidos exitosamente, total: {}", seguridads.size());
            return ResponseEntity.ok(seguridads);
        } catch (Exception ex) {
            logger.error("Error al obtener seguridads: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al obtener seguridads");
        }
    }
}
