package org.formation.dto;

import lombok.Data;

@Data
public class ProduitRequest {

	String reference;
	int amount;
	
	boolean availability;
	
	long originalId;
}
