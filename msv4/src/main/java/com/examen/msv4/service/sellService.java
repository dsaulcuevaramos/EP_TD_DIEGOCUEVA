package com.examen.msv4.service;

import java.util.List;

import com.examen.msv4.entity.sell;

public interface sellService {

    public sell createSell(sell sellNuevo);

    public sell getSellById(int codigo);

    public List<sell> getAllSells();

    public boolean deleteSellById(int codigo);

}
