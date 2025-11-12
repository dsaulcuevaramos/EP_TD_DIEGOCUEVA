package com.examen.msv1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.msv1.entity.movimiento;

@Repository
public interface movimientoRepository extends JpaRepository<movimiento, Integer> {
    
}
