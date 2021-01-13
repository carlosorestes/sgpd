package com.sgpd.br.repositories;

import com.sgpd.br.dto.VehicleDTO;
import com.sgpd.br.entities.OrderVehicle;

public class OrderVehicleEntityAssembler {

	public OrderVehicle toEntity(VehicleDTO vehicleDTO) {
		OrderVehicle orderVehicle = new OrderVehicle();
		return orderVehicle;
	}
}
