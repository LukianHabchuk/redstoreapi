package com.example.redstoreapi.repository;

import com.example.redstoreapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long aLong);
    void deleteById(long id);
}
