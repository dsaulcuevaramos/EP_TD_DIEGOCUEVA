package com.examen.msv1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.msv1.entity.usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Integer> {

}