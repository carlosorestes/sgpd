package com.sgpd.br.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sgpd.br.dto.OrderDTO;
import com.sgpd.br.dto.VehicleDTO;
import com.sgpd.br.entities.Order;
import com.sgpd.br.entities.OrderVehicle;
import com.sgpd.br.entities.Person;
import com.sgpd.br.entities.User;
import com.sgpd.br.entities.Vehicle;
import com.sgpd.br.enums.TipoVeiculo;
import com.sgpd.br.repositories.OrderRepository;

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
	
	@Autowired
	private BpmService bpmService;
	
	public List<Order> findAll(){
		return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	public Order findbyId(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}
	
	@Async
	public Order replaceAndSaveOrder(OrderDTO dto) throws IOException {
		List<OrderVehicle> listOrderVehicle = new ArrayList<OrderVehicle>();
		Order order = new Order();
		Person person = personService.findByCpf(dto.getCpfPerson());
//		TODO: Fit method to parse parameter with current user to create order
//		order.setUser(userService.findbyNome(dto.getUserNome()));
		User user = userService.findbyNome("user1");
		
		order = dto.buildOrder(user, person);
		
		for(VehicleDTO vehicleDTO: dto.getListVehicles()) {
			OrderVehicle orderVehicle = new OrderVehicle();
			Vehicle vehicle = new Vehicle();
			vehicle = vehicleService.findByRenavam(vehicleDTO.getRenavam());
			
			if (vehicle == null) {
				vehicle = new Vehicle(vehicleDTO.getId(), vehicleDTO.getAno(), vehicleDTO.getModelo(), vehicleDTO.getCor(), 
						vehicleDTO.getPlaca(), vehicleDTO.getRenavam(), TipoVeiculo.tipoVeiculoOfByValue(Integer.parseInt(vehicleDTO.getTipo())));	
				vehicleService.save(vehicle);
			}
//			Map<String, String> mapResponseBpm = bpmService.startProcessDefinitionKey("consult_traffic_ticket");
			orderVehicle.setOrder(order);
			orderVehicle.setVehicle(vehicle);
//			orderVehicle.setRequestBbpmId(mapResponseBpm.get("requestBbpmId").toString());
			listOrderVehicle.add(orderVehicle);
		}
		order.setListOrderVehicle(listOrderVehicle);
		
		order = orderRepository.saveAndFlush(order);
		
		bpmService.startProcessDefinitionKey("consult_traffic_ticket", order);
		
		return order;
	}

	public List<Order> findByPersonByCpf(String cpf) {
		return orderRepository.findByOrderPersonByCpf(cpf);
	}
	
	
}
