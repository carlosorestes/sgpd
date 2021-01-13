package com.sgpd.br.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgpd.br.dto.OrderDTO;
import com.sgpd.br.entities.Order;
import com.sgpd.br.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(Pageable  pageable){
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order order = orderService.findbyId(id);
		return ResponseEntity.ok().body(order);
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	@ResponseBody
	public ResponseEntity<List<Order>> findByCpf(@PathVariable String cpf){
		return ResponseEntity.ok().body(orderService.findByPersonByCpf(cpf));
	}
	
	@PostMapping
	public ResponseEntity<Order> create(@RequestBody OrderDTO orderDTO) throws IOException {
		return ResponseEntity.ok().body(orderService.replaceAndSaveOrder(orderDTO));
	}
}
