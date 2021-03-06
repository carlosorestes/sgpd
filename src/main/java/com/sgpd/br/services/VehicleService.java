package com.sgpd.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sgpd.br.dto.VehicleDTO;
import com.sgpd.br.entities.OrderVehicle;
import com.sgpd.br.entities.Vehicle;
import com.sgpd.br.repositories.OrderRepository;
import com.sgpd.br.repositories.OrderVehicleRepository;
import com.sgpd.br.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private OrderVehicleRepository orderVehicleRepository;
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.saveAndFlush(vehicle);
	}
	
	public Vehicle findByRenavam(String renavam) {
		return vehicleRepository.findByRenavam(renavam);
	}
	
	public VehicleDTO findOrderVehicleByRenavamOrderId(String renavam, Long orderId) {
		VehicleDTO vehicleDTO = new VehicleDTO();
		OrderVehicle orderVehicle = orderVehicleRepository.findOrderVehicleByRenavamOrderId(renavam, orderId);
		vehicleDTO.setId(orderVehicle.getOrder().getId());
		vehicleDTO.setTipoVeiculo(orderVehicle.getVehicle().getTipoVeiculo());
		vehicleDTO.setAno(orderVehicle.getVehicle().getAno());
		vehicleDTO.setModelo(orderVehicle.getVehicle().getModelo());
		vehicleDTO.setCor(orderVehicle.getVehicle().getCor());
		vehicleDTO.setPlaca(orderVehicle.getVehicle().getPlaca());
		vehicleDTO.setRenavam(orderVehicle.getVehicle().getRenavam());
		return vehicleDTO;
	}
	
	public OrderVehicle updateStatusVehicleByOrderIdAndRenavam(String renavam, Long orderId, VehicleDTO vehicleDTO) {
		OrderVehicle orderVehicleMerged = orderVehicleRepository.findOrderVehicleByRenavamOrderId(renavam, orderId);
		if(vehicleDTO != null) {
			if(!StringUtils.isEmpty(vehicleDTO.getStatus())) {
				orderVehicleMerged.setStatus(vehicleDTO.getStatus());
			}
			
			if(!StringUtils.isEmpty(vehicleDTO.getLogExternalData())) {
				orderVehicleMerged.setLogExternalData(vehicleDTO.getLogExternalData());
			}
		}
		return orderVehicleRepository.save(orderVehicleMerged);
	}
}
