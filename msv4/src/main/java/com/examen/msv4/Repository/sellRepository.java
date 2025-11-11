package com.examen.msv4.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen.msv4.entity.sell;

@Repository
public interface sellRepository extends MongoRepository<sell, String> {

    Optional<sell> findByCodigo(int codigo);

    void deleteByCodigo(int codigo);

}
