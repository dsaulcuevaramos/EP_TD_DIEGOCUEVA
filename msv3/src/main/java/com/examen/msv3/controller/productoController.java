package com.examen.msv3.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.msv3.config.ApiRoutes;
import com.examen.msv3.entity.productos;
import com.examen.msv3.service.productoService;

@RestController
public class productoController {

    @Autowired
    @Qualifier("productoService")
    private productoService productoService;

    private final Logger logger = LoggerFactory.getLogger(productoController.class);

    @GetMapping(ApiRoutes.Producto.GET_ALL)
    public ResponseEntity<?> obtenerTodosLosProductos() {
        try {
            List<productos> productos = productoService.obtenerTodosLosProductos();
            logger.info("Productos obtenidos exitosamente, total: {}", productos.size());
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            logger.error("Error al obtener los productos: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
            // logger.error("Error al obtener clientes: {}", e.getMessage(), e);
            // return ResponseEntity.internalServerError().body("Error al obtener
            // clientes");
        }
    }

    @GetMapping(ApiRoutes.Producto.GET_BY_ID)
    public ResponseEntity<?> obtenerpPorId(@PathVariable int id_producto) {
        try {
            productos producto = productoService.obtenerProductoPorId(id_producto);
            if (producto != null) {
                logger.info("Producto con ID {} obtenido exitosamente", id_producto);
                return ResponseEntity.ok(producto);
            } else {
                logger.warn("Producto con ID {} no encontrado", id_producto);
                return ResponseEntity.status(404).body("Producto no encontrado");
            }
        } catch (Exception e) {
            logger.error("Error al obtener el producto con ID {}: {}", id_producto, e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @PostMapping(ApiRoutes.Producto.CREATE)
    public ResponseEntity<?> crearProducto(@RequestBody productos producto) {
        try {
            productos nuevoProducto = productoService.guardarProducto(producto);
            logger.info("Producto creado exitosamente con ID {}", nuevoProducto.getId_producto());
            return ResponseEntity.ok(nuevoProducto);
        } catch (Exception e) {
            logger.error("Error al crear el producto: {}", e.getMessage());
            return ResponseEntity.internalServerError().body("Error al crear el producto");
        }
    }

    @PutMapping(ApiRoutes.Producto.UPDATE)
    public ResponseEntity<?> actualizarProducto(@PathVariable int id_producto, @RequestBody productos producto) {
        try {
            productos productoExistente = productoService.obtenerProductoPorId(id_producto);
            if (productoExistente != null) {
                productoExistente.setNombre(producto.getNombre());
                productoExistente.setPrecio(producto.getPrecio());
                productos productoActualizado = productoService.guardarProducto(productoExistente);
                logger.info("Producto con ID {} actualizado exitosamente", id_producto);
                return ResponseEntity.ok(productoActualizado);
            } else {
                logger.warn("Producto con ID {} no encontrado para actualizar", id_producto);
                return ResponseEntity.status(404).body("Producto no encontrado");
            }
        } catch (Exception e) {
            logger.error("Error al actualizar el producto con ID {}: {}", id_producto, e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @DeleteMapping(ApiRoutes.Producto.DELETE)
    public ResponseEntity<?> eliminarProducto(@PathVariable int id_producto) {
        try {
            boolean eliminado = productoService.eliminarProducto(id_producto);
            if (eliminado) {
                logger.info("Producto con ID {} eliminado exitosamente", id_producto);
                return ResponseEntity.ok("Producto eliminado exitosamente");
            } else {
                logger.warn("Producto con ID {} no encontrado para eliminar", id_producto);
                return ResponseEntity.status(404).body("Producto no encontrado");
            }
        } catch (Exception e) {
            logger.error("Error al eliminar el producto con ID {}: {}", id_producto, e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

}
