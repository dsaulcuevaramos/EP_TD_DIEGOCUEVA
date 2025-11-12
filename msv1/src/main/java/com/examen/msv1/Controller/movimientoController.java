package com.examen.msv1.Controller;

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

import com.examen.msv1.Service.movimientoService;
import com.examen.msv1.config.ApiRoutes;
import com.examen.msv1.entity.movimiento;

@RestController
public class movimientoController {

    @Autowired
    @Qualifier("movimientoService")
    private movimientoService movimientoService;

    private final Logger logger = LoggerFactory.getLogger(movimientoController.class);


    @GetMapping(ApiRoutes.Movimiento.GET_ALL)
    public ResponseEntity<?> getAllUsuarios() {
        try {
            List<movimiento> movimoentos = movimientoService.obtener();
            logger.info("Usuarios obtenidos exitosamente, total: {}", movimoentos.size());
            return ResponseEntity.ok(movimoentos);
        } catch (Exception ex) {
            logger.error("Error al obtener movimientos: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al obtener movimientos");
        }
    }

    @PostMapping(ApiRoutes.Movimiento.CREATE)
    public ResponseEntity<?> create(@RequestBody movimiento newmov)     {
        try {
            movimiento movi = movimientoService.guardarMovimiento(newmov);
            logger.info("Usuario creado exitosamente: {}", movi);
            return ResponseEntity.ok(movi);
        } catch (Exception ex) {
            logger.error("Error al crear usuario: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al crear usuario");
        }
    }
    
}
