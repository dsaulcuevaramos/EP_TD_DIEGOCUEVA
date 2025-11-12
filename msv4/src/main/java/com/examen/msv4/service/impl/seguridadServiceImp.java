package com.examen.msv4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.msv4.Repository.seguridadRepository;
import com.examen.msv4.service.seguridadService;
import com.examen.msv4.entity.seguridad;

@Service
public class seguridadServiceImp implements seguridadService{
 
     @Autowired
    private seguridadRepository SeguridadRepository;


    @Override
    public seguridad loginByNombreClave(String nombre, String clave){
        return SeguridadRepository.loginByNombreClave(nombre, clave).orElse(null);
    }

    @Override
    public List<seguridad> getByNombre(String nombre){
        return SeguridadRepository.findByNombre(nombre);
    }

    @Override
    public seguridad getByClave(String clave){
        return SeguridadRepository.findByClave(clave).orElse(null);
    }

}
