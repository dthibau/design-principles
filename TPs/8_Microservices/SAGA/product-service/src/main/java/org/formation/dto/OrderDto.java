package org.formation.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.formation.dto.ProduitRequest;

import lombok.Data;


@Data
public class OrderDto {


	private long id;
	
	private Instant date;
	
	private float discount;
	
	
	List<OrderItemDto> orderItems = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}

	public List<ProduitRequest> asProduitRequest() {
		List<ProduitRequest> ret = new ArrayList<>();
		for ( OrderItemDto oi : orderItems ) {
			ProduitRequest pr = new ProduitRequest();
			pr.setAmount(oi.getQuantity());
			pr.setReference(oi.getRefProduct());
		}
		return ret;
	}
}
