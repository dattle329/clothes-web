package com.example.grabfoodapp.repository;

import com.example.grabfoodapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
