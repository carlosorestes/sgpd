package com.sgpd.br.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbOrderVehicle")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "order")
public class OrderVehicle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @PrePersist
	   private void prePersiste() {
	       if (getOrderVehicleId() == null) {
	    	   OrderVehicleId pk = new OrderVehicleId();
	           pk.setOrderId(getOrder().getId());
	           pk.setVehicleId(getVehicle().getId());
	           setOrderVehicleId(pk);
	       }
	   }
	
	@EmbeddedId
    protected OrderVehicleId orderVehicleId	;

    @ManyToOne
    @JoinColumn(name ="order_id", insertable = false, updatable = false)
	private Order order;
	
    @ManyToOne
    @JoinColumn(name ="vehicle_id", insertable = false, updatable = false)
	private Vehicle vehicle;
	
	@CreationTimestamp
    private LocalDateTime createDateTime;
 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
	
	private String status;
	
	private String requestBbpmId;
	
	@Column(name = "log_external_data")
	private String logExternalData;
	
	public OrderVehicle() {
		
	}

	public OrderVehicle(Order order, Vehicle vehicle, String requestBbpmId) {
		this.order = order;
		this.vehicle = vehicle;
		this.requestBbpmId = requestBbpmId;
	}

	public OrderVehicleId getOrderVehicleId() {
		return orderVehicleId;
	}

	public void setOrderVehicleId(OrderVehicleId orderVehicleId) {
		this.orderVehicleId = orderVehicleId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestBbpmId() {
		return requestBbpmId;
	}

	public void setRequestBbpmId(String requestBbpmId) {
		this.requestBbpmId = requestBbpmId;
	}

	public String getLogExternalData() {
		return logExternalData;
	}

	public void setLogExternalData(String logExternalData) {
		this.logExternalData = logExternalData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((requestBbpmId == null) ? 0 : requestBbpmId.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderVehicle other = (OrderVehicle) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (requestBbpmId == null) {
			if (other.requestBbpmId != null)
				return false;
		} else if (!requestBbpmId.equals(other.requestBbpmId))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderVehicle [orderVehicleId=" + orderVehicleId + ", order=" + order + ", vehicle=" + vehicle
				+ ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + ", status=" + status
				+ ", requestBbpmId=" + requestBbpmId + ", logExternalData=" + logExternalData + "]";
	}
}
