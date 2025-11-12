package com.examen.msv4.service;

import java.util.List;

import com.examen.msv4.entity.seguridad;

public interface seguridadService {
    
    //public seguridad loginByNombreClave(String nombre, String clave);
    public List<seguridad> obtener();
    
    public List<seguridad> getByNombre(String nombre);
    public seguridad getByClave(String clave);
   
    
}
