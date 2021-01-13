package com.sgpd.br.resources;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	private OrderVehicleResourceAssembler orderVehicleAssembler;
	
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
	
	@PatchMapping(value = "/renavam/{renavam}/orderId/{orderId}")
	public ResponseEntity<VehicleDTO> update(@PathVariable String renavam, @PathVariable Long orderId, @RequestBody VehicleDTO vehicleDTO) throws IOException {
		VehicleDTO veiVehicle = orderVehicleAssembler.toResource(vehicleService.updateStatusVehicleByOrderIdAndRenavam(renavam, orderId, vehicleDTO));
		return ResponseEntity.ok().body(veiVehicle);
	}

}
