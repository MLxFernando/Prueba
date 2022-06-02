package com.prueba.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByTitle(String criteria);
}
