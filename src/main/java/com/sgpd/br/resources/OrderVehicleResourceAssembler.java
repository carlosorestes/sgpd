package com.sgpd.br.resources;

import org.springframework.stereotype.Component;

import com.sgpd.br.dto.VehicleDTO;
import com.sgpd.br.entities.OrderVehicle;

@Component
public class OrderVehicleResourceAssembler {

	public VehicleDTO toResource(OrderVehicle orderVehicle) {
		VehicleDTO vehicleDTO = new VehicleDTO();
			vehicleDTO.setId(orderVehicle.getVehicle().getId());
			vehicleDTO.setTipoVeiculo(orderVehicle.getVehicle().getTipoVeiculo());
			vehicleDTO.setAno(orderVehicle.getVehicle().getAno());
			vehicleDTO.setModelo(orderVehicle.getVehicle().getModelo());
			vehicleDTO.setCor(orderVehicle.getVehicle().getCor());
			vehicleDTO.setPlaca(orderVehicle.getVehicle().getPlaca());
			vehicleDTO.setRenavam(orderVehicle.getVehicle().getRenavam());
			vehicleDTO.setStatus(orderVehicle.getStatus());
			vehicleDTO.setLogExternalData(orderVehicle.getLogExternalData());
		return vehicleDTO;
	}
}
