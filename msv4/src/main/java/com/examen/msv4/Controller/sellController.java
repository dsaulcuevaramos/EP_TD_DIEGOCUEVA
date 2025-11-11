package com.examen.msv4.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.msv4.config.ApiRoutes;
import com.examen.msv4.entity.sell;
import com.examen.msv4.service.sellService;

@RestController
public class sellController {

    @Autowired
    private sellService sellService;

    private static final Logger logger = LoggerFactory.getLogger(sellController.class);

    @GetMapping(ApiRoutes.Sell.GET_ALL)
    public ResponseEntity<?> getAllSells() {
        try {
            List<sell> sells = sellService.getAllSells();
            if (sells.isEmpty()) {
                logger.warn("No se encontraron ventas");
                return ResponseEntity.status(404).body("No se encontraron ventas");
            }
            logger.info("Ventas obtenidos exitosamente, total: {}", sells.size());
            return ResponseEntity.ok(sells);
        } catch (Exception e) {
            logger.error("Error al obtener ventas: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error al obtener ventas");
        }
    }

    @GetMapping(ApiRoutes.Sell.GET_BY_ID)
    public ResponseEntity<?> getSellById(@PathVariable int id_sell) {
        try {
            sell venta = sellService.getSellById(id_sell);
            if (venta != null) {
                logger.info("Venta con ID {} obtenida exitosamente", id_sell);
                return ResponseEntity.ok(venta);
            } else {
                logger.warn("Venta con ID {} no encontrada", id_sell);
                return ResponseEntity.status(404).body("Venta no encontrada");
            }
        } catch (Exception e) {
            logger.error("Error al obtener la venta con ID {}: {}", id_sell, e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @PostMapping(ApiRoutes.Sell.CREATE)
    public ResponseEntity<?> createSell(@RequestBody sell nuevaVenta) {
        try {
            nuevaVenta.setTotal_precio(nuevaVenta.getPrecio_unitario() * nuevaVenta.getCantidad());
            sell createdSell = sellService.createSell(nuevaVenta);
            logger.info("Venta creada exitosamente con ID {}", createdSell.getId());
            return ResponseEntity.ok(createdSell);
        } catch (Exception e) {
            logger.error("Error al crear la venta: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @PutMapping(ApiRoutes.Sell.UPDATE)
    public ResponseEntity<?> updateSell(@PathVariable int id_sell, @RequestBody sell ventaActualizada) {
        try {
            sell sellExistente = sellService.getSellById(id_sell);
            if (sellExistente != null) {
                sellExistente.setNombre_producto(ventaActualizada.getNombre_producto());
                sellExistente.setCantidad(ventaActualizada.getCantidad());
                sellExistente.setPrecio_unitario(ventaActualizada.getPrecio_unitario());
                sellExistente.setTotal_precio(ventaActualizada.getPrecio_unitario() * ventaActualizada.getCantidad());
                sell updatedSell = sellService.createSell(sellExistente);
                logger.info("Venta con ID {} actualizada exitosamente", id_sell);
                return ResponseEntity.ok(updatedSell);
            } else {
                logger.warn("Venta con ID {} no encontrada para actualizar", id_sell);
                return ResponseEntity.status(404).body("Venta no encontrada");
            }

        } catch (Exception e) {
            logger.error("Error al actualizar la venta con ID {}: {}", id_sell, e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @DeleteMapping(ApiRoutes.Sell.DELETE)
    public ResponseEntity<?> deleteSell(@PathVariable int id_sell) {
        try {
            boolean deleted = sellService.deleteSellById(id_sell);
            if (deleted) {
                logger.info("Venta con ID {} eliminada exitosamente", id_sell);
                return ResponseEntity.ok("Venta eliminada exitosamente");
            } else {
                logger.warn("Venta con ID {} no encontrada para eliminar", id_sell);
                return ResponseEntity.status(404).body("Venta no encontrada");
            }
        } catch (Exception e) {
            logger.error("Error al eliminar la venta con ID {}: {}", id_sell, e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

}
