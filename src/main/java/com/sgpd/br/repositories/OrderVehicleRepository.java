package com.sgpd.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgpd.br.entities.OrderVehicle;
import com.sgpd.br.entities.OrderVehicleId;

public interface OrderVehicleRepository extends JpaRepository<OrderVehicle, OrderVehicleId> {
	
	@Query("select ov from OrderVehicle ov inner join ov.order o inner join ov.vehicle v where o.id = :orderId and v.renavam = :renavam")
	OrderVehicle findOrderVehicleByRenavamOrderId(String renavam, Long orderId);

}
