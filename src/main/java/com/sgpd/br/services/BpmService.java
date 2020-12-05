package com.sgpd.br.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgpd.br.entities.Order;
import com.sgpd.br.entities.OrderVehicle;
import com.sgpd.br.gateway.BpmGateway;

@Service
public class BpmService {
	
	@Autowired
	private BpmGateway bpmGateway;
	
	public Map<String, String> startProcessDefinitionKey(String processDefinitionKey, Order order) throws IOException {
		Map<String, String> responseBbm = new HashMap<>();
		for(OrderVehicle orderVehicle: order.getListOrderVehicle()) {
			bpmGateway.startProcessDefinitionKey(processDefinitionKey, orderVehicle.getVehicle().getRenavam(), order.getId());
		}
		
		return responseBbm;
	}

}
