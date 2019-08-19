package com.sgpd.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgpd.br.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	
	
}
