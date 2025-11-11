package com.examen.msv1.Service;

import java.util.List;

import com.examen.msv1.entity.usuario;

public interface UsuarioService {

    public usuario guardarUsuario(usuario usuario);

    public usuario obtenerUsuarioPorID(int idUsuario);

    public List<usuario> obtenerUsuarios();

    public boolean eliminarUsuario(int idUsuario);

}
