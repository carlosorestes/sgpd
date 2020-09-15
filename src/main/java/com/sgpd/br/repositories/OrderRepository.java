package com.sgpd.br.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgpd.br.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("select o from Order o inner join o.person p where p.cpf = :cpf")
	List<Order> findByOrderPersonByCpf(String cpf);
	
}
