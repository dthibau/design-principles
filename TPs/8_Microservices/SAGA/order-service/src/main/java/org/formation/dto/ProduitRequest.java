package org.formation.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class ProduitRequest {

	String reference;
	@JsonAlias({"originalId"})
	long orderId;
	boolean availability;
	
	
	
}
