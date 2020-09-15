package com.sgpd.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgpd.br.entities.Vehicle;
import com.sgpd.br.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	public Vehicle findByRenavam(String renavam) {
		return vehicleRepository.findByRenavam(renavam);
	}
}
