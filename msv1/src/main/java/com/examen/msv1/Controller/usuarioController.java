package com.examen.msv1.Controller;

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

import com.examen.msv1.Service.UsuarioService;
import com.examen.msv1.config.ApiRoutes;
import com.examen.msv1.entity.usuario;

@RestController
public class usuarioController {

    @Autowired
    @Qualifier("usuarioService")
    private UsuarioService usuarioService;

    private final Logger logger = LoggerFactory.getLogger(usuarioController.class);

    @GetMapping(ApiRoutes.Usuario.GET_ALL)
    public ResponseEntity<?> getAllUsuarios() {
        try {
            List<usuario> usuarios = usuarioService.obtenerUsuarios();
            logger.info("Usuarios obtenidos exitosamente, total: {}", usuarios.size());
            return ResponseEntity.ok(usuarios);
        } catch (Exception ex) {
            logger.error("Error al obtener usuarios: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al obtener usuarios");
        }
    }

    @GetMapping(ApiRoutes.Usuario.GET_BY_ID)
    public ResponseEntity<?> getUsuarioById(@PathVariable int id) {
        try {
            usuario usuario = usuarioService.obtenerUsuarioPorID(id);
            if (usuario == null) {
                logger.warn("Usuario con ID {} no encontrado", id);
                return ResponseEntity.notFound().build();
            }
            logger.info("Usuario obtenido exitosamente: {}", usuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception ex) {
            logger.error("Error al obtener usuario con ID {}: {}", id, ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al obtener usuario");
        }
    }

    @PostMapping(ApiRoutes.Usuario.CREATE)
    public ResponseEntity<?> createUsuario(@RequestBody usuario newUsuario)     {
        try {
            usuario nuevo = usuarioService.guardarUsuario(newUsuario);
            logger.info("Usuario creado exitosamente: {}", nuevo);
            return ResponseEntity.ok(nuevo);
        } catch (Exception ex) {
            logger.error("Error al crear usuario: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al crear usuario");
        }
    }

    @PutMapping(ApiRoutes.Usuario.UPDATE)
    public ResponseEntity<?> updateUsuario(@PathVariable int id, @RequestBody usuario updatedUsuario) {
        try {
            usuario Usuario = usuarioService.obtenerUsuarioPorID(id);
            if (Usuario == null) {
                logger.warn("Usuario con ID {} no encontrado", id);
                return ResponseEntity.notFound().build();
            }

            updatedUsuario.setIdUsuario(id);
            usuario usuarioActualizado = usuarioService.guardarUsuario(updatedUsuario);
            logger.info("Usuario actualizado exitosamente: {}", usuarioActualizado);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (Exception ex) {
            logger.error("Error al actualizar usuario con ID {}: {}", id, ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al actualizar usuario");
        }
    }

    @DeleteMapping(ApiRoutes.Usuario.DELETE)
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
        try {
            boolean eliminado = usuarioService.eliminarUsuario(id);
            if (!eliminado) {
                logger.warn("Usuario con ID {} no encontrado", id);
                return ResponseEntity.notFound().build();
            }

            logger.info("Usuario con ID {} eliminado exitosamente", id);
            return ResponseEntity.ok().body("Usuario eliminado exitosamente");
        } catch (Exception ex) {
            logger.error("Error al eliminar usuario con ID {}: {}", id, ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Error al eliminar usuario");
        }
    }

}
