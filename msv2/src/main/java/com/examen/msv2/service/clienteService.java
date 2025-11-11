package com.examen.msv2.service;

import java.util.List;

import com.examen.msv2.entity.cliente;

public interface clienteService {

    public cliente guardarCliente(cliente cliente);

    public cliente obtenerClientePorId(int id_cliente);

    public List<cliente> obtenerTodosLosClientes();

    public boolean eliminarCliente(int id_cliente);
}
