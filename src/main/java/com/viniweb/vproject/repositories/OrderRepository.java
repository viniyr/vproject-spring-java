package com.viniweb.vproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniweb.vproject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
}
