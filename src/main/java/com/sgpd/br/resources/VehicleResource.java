package com.sgpd.br.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgpd.br.dto.VehicleDTO;
import com.sgpd.br.entities.Vehicle;
import com.sgpd.br.services.VehicleService;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleResource {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping(value = "/{renavam}")
	public ResponseEntity<Vehicle> findByRenavam(@PathVariable String renavam){
		Vehicle veiVehicle = vehicleService.findByRenavam(renavam);
		return ResponseEntity.ok().body(veiVehicle);
	}
	
	@GetMapping(value = "/renavam/{renavam}/order/{orderId}")
	public ResponseEntity<VehicleDTO> findById(@PathVariable String renavam, @PathVariable Long orderId){
		VehicleDTO veiVehicle = vehicleService.findOrderVehicleByRenavamOrderId(renavam, orderId);
		return ResponseEntity.ok().body(veiVehicle);
	}
	
	@GetMapping(value = "/requestBbpmId/{requestBbpmId}")
	public ResponseEntity<VehicleDTO> findById(@PathVariable String requestBbpmId){
		VehicleDTO veiVehicle = vehicleService.findOrderVehicleByRequestBbpmId(requestBbpmId);
		return ResponseEntity.ok().body(veiVehicle);
	}

}
