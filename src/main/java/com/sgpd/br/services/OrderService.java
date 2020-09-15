package com.sgpd.br.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sgpd.br.dto.OrderDTO;
import com.sgpd.br.dto.VehicleDTO;
import com.sgpd.br.entities.Order;
import com.sgpd.br.entities.Vehicle;
import com.sgpd.br.enums.TipoVeiculo;
import com.sgpd.br.repositories.OrderRepository;
import com.sgpd.br.repositories.VehicleRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VehicleService vehicleService;
	
	public List<Order> findAll(){
		return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	public Order findbyId(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}
	
	@Transactional
	public Order replaceAndSaveOrder(OrderDTO dto) {
		List<Vehicle> lisVehicles = new ArrayList<Vehicle>();
		Order order = dto.buildOrder(dto);
		order.setPerson(personService.findByCpf(dto.getCpfPerson()));
		
//		TODO: Fit method to parse parameter with current user to create order
//		order.setUser(userService.findbyNome(dto.getUserNome()));
		order.setUser(userService.findbyNome("user1"));
		
		for(VehicleDTO vehicleDTO: dto.getListVehicles()) {
			Vehicle vehicle = new Vehicle();
			vehicle = vehicleService.findByRenavam(vehicleDTO.getRenavam());
			
			if (vehicle == null) {
				vehicle = new Vehicle(vehicleDTO.getId(), vehicleDTO.getAno(), vehicleDTO.getModelo(), vehicleDTO.getCor(), 
						vehicleDTO.getPlaca(), vehicleDTO.getRenavam(), TipoVeiculo.tipoVeiculoOfByValue(Integer.parseInt(vehicleDTO.getTipo())));	
				lisVehicles.add(vehicle);
			}
			
			vehicleService.save(vehicle);
		}
		
		order.setListVeiculo(lisVehicles);
		
		return orderRepository.save(order);
	}

	public List<Order> findByPersonByCpf(String cpf) {
		return orderRepository.findByOrderPersonByCpf(cpf);
	}
	
}
