package com.examen.msv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.msv2.entity.articulo;

@Repository("articuloRepository")
public interface articuloRepository extends JpaRepository<articulo, Integer>{
    
}
