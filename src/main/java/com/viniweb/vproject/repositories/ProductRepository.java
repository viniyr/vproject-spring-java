package com.viniweb.vproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniweb.vproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
