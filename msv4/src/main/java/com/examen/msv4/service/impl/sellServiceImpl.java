package com.examen.msv4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.msv4.Repository.sellRepository;
import com.examen.msv4.entity.sell;
import com.examen.msv4.service.sellService;

@Service
public class sellServiceImpl implements sellService {

    @Autowired
    private sellRepository sellRepository;

    @Override
    public sell createSell(sell sellNuevo) {
        return sellRepository.save(sellNuevo);
    }

    @Override
    public sell getSellById(int codigo) {
        return sellRepository.findByCodigo(codigo).orElse(null);
    }

    @Override
    public List<sell> getAllSells() {
        return sellRepository.findAll();
    }

    @Override
    public boolean deleteSellById(int codigo) {
        if (sellRepository.findByCodigo(codigo).isPresent()) {
            sellRepository.deleteByCodigo(codigo);
            return true;
        }
        return false;
    }

}
