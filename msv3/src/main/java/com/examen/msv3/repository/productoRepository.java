package com.examen.msv3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.msv3.entity.productos;

@Repository("productoRepository")
public interface productoRepository extends JpaRepository<productos, Integer> {

}
