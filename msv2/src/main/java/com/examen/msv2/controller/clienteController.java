package com.examen.msv2.controller;

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

import com.examen.msv2.config.ApiRoutes;
import com.examen.msv2.entity.cliente;
import com.examen.msv2.service.clienteService;

@RestController
public class clienteController {

    @Autowired
    @Qualifier("clienteService")
    private clienteService clienteService;

    private final Logger logger = LoggerFactory.getLogger(clienteController.class);

    @GetMapping(ApiRoutes.clienteRoutes.GET_ALL)
    public ResponseEntity<?> obtenerTodosLosClientes() {
        try {
            List<cliente> clientes = clienteService.obtenerTodosLosClientes();
            logger.info("Usuarios obtenidos exitosamente, total: {}", clientes.size());
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            logger.error("Error al obtener clientes: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error al obtener clientes");
        }

    }

    @GetMapping(ApiRoutes.clienteRoutes.GET_BY_ID)
    public ResponseEntity<?> obtenerClientePorId(@PathVariable int id_cliente) {
        try {
            cliente cliente = clienteService.obtenerClientePorId(id_cliente);
            if (cliente != null) {
                logger.info("Cliente con ID {} obtenido exitosamente", id_cliente);
                return ResponseEntity.ok(cliente);
            } else {
                logger.warn("Cliente con ID {} no encontrado", id_cliente);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error al obtener cliente con ID {}: {}", id_cliente, e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error al obtener cliente");
        }
    }

    @PostMapping(ApiRoutes.clienteRoutes.CREATE)
    public ResponseEntity<?> crearCliente(@RequestBody cliente cliente) {
        try {
            cliente nuevoCliente = clienteService.guardarCliente(cliente);
            logger.info("Cliente creado exitosamente con ID {}", nuevoCliente.getId_cliente());
            return ResponseEntity.ok(nuevoCliente);
        } catch (Exception e) {
            logger.error("Error al crear cliente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error al crear cliente");
        }
    }

    @PutMapping(ApiRoutes.clienteRoutes.UPDATE)
    public ResponseEntity<?> actualizarCliente(@PathVariable int id_cliente, @RequestBody cliente cliente) {
        try {
            cliente clienteExistente = clienteService.obtenerClientePorId(id_cliente);
            if (clienteExistente == null) {
                logger.warn("Cliente con ID {} no encontrado para actualizar", id_cliente);
                return ResponseEntity.notFound().build();
            }
            clienteExistente.setId_cliente(id_cliente);
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setTelefono(cliente.getTelefono());
            cliente actualizado = clienteService.guardarCliente(clienteExistente);
            logger.info("Cliente con ID {} actualizado exitosamente", id_cliente);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            logger.error("Error al actualizar cliente con ID {}: {}", id_cliente, e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error al actualizar cliente");
        }
    }

    @DeleteMapping(ApiRoutes.clienteRoutes.DELETE)
    public ResponseEntity<?> eliminarCliente(@PathVariable int id_cliente) {
        try {
            boolean eliminado = clienteService.eliminarCliente(id_cliente);
            if (eliminado) {
                logger.info("Cliente con ID {} eliminado exitosamente", id_cliente);
                return ResponseEntity.ok().body("cliente eliminado exitosamente");
            } else {
                logger.warn("Cliente con ID {} no encontrado para eliminar", id_cliente);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error al eliminar cliente con ID {}: {}", id_cliente, e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error al eliminar cliente");
        }
    }
}
