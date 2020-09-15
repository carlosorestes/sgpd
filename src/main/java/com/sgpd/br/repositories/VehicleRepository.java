package com.sgpd.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgpd.br.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
	public Vehicle findByRenavam(String nome);
}
