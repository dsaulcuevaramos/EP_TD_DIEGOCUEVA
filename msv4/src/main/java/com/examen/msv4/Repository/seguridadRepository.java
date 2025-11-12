package com.examen.msv4.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen.msv4.entity.seguridad;


@Repository
public interface seguridadRepository extends MongoRepository<seguridad, String>{

    //Optional<seguridad> loginByNombreClave(String nombre, String codigo);
    List<seguridad> findByNombre(String nombre);
    Optional<seguridad> findByClave(String clave);
    

}
