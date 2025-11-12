package com.examen.msv1.Service;

import java.util.List;

import com.examen.msv1.entity.movimiento;

public interface movimientoService {
    
    public movimiento guardarMovimiento(movimiento Movimiento);
    public List<movimiento> obtener();
}
