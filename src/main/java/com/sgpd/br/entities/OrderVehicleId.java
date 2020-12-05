package com.sgpd.br.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderVehicleId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "vehicle_id")
	private Long vehicleId;
	
	public OrderVehicleId() {
	}

	public OrderVehicleId(Long orderId, Long vehicleId) {
		this.orderId = orderId;
		this.vehicleId = vehicleId;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	

}
