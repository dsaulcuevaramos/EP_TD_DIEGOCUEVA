package com.examen.msv2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.examen.msv2.entity.cliente;
import com.examen.msv2.repository.clienteRepository;
import com.examen.msv2.service.clienteService;

@Service("clienteService")
public class clienteServiceImpl implements clienteService {

    @Autowired
    @Qualifier("clienteRepository")
    private clienteRepository clienteRepository;

    @Override
    public cliente guardarCliente(cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public cliente obtenerClientePorId(int id_cliente) {
        return clienteRepository.findById(id_cliente).orElse(null);
    }

    @Override
    public List<cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public boolean eliminarCliente(int id_cliente) {
        if (clienteRepository.existsById(id_cliente)) {
            clienteRepository.deleteById(id_cliente);
            return true;
        }
        return false;
    }

}
