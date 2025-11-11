package com.examen.msv1.Service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.examen.msv1.Repository.UsuarioRepository;
import com.examen.msv1.Service.UsuarioService;
import com.examen.msv1.entity.usuario;

@Service("usuarioService")
public class usuarioServiceImpl implements UsuarioService {

    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;

    public final Logger logger = LoggerFactory.getLogger(usuarioServiceImpl.class);

    @Override
    public usuario obtenerUsuarioPorID(int idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);

    }

    @Override
    public List<usuario> obtenerUsuarios() {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al obtener los usuarios: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public boolean eliminarUsuario(int idUsuario) {
        try {
            if (usuarioRepository.existsById(idUsuario)) {
                usuarioRepository.deleteById(idUsuario);
                return true;
            } else {
                logger.warn("El usuario con ID " + idUsuario + " no existe.");
                return false;
            }
        } catch (Exception e) {
            logger.error("Error al eliminar el usuario: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public usuario guardarUsuario(usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            logger.error("Error al guardar el usuario: " + e.getMessage(), e);
            throw e;
        }
    }

}
