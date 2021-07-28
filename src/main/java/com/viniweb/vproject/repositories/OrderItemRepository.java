package com.viniweb.vproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniweb.vproject.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
}
