package com.examen.msv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.msv2.entity.cliente;

@Repository("clienteRepository")
public interface clienteRepository extends JpaRepository<cliente, Integer> {

}
