package com.datrastoco.administration_service.products.repositories;

import com.datrastoco.administration_service.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
}
