package org.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.formation.ProduitRequestStream;
import org.formation.dto.OrderDto;
import org.formation.dto.ProduitRequest;
import org.formation.model.Produit;
import org.formation.model.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class ProduitService {

	@Autowired
	ProduitRequestStream produitRequestStream;
	
	@Autowired
	ProduitRepository produitRepository;
	
	protected Logger logger = Logger.getLogger(ProduitService.class.getName());
	
	@StreamListener(ProduitRequestStream.INPUT)
    public void handleRequest(@Payload OrderDto order) {
		logger.info("handleRequest order = " + order.getId());
		List<ProduitRequest> produitRequest = new ArrayList<>();
		
		order.getOrderItems().stream().forEach(oi -> {
			ProduitRequest pr = new ProduitRequest();
			pr.setReference(oi.getRefProduct());
			pr.setAmount(oi.getQuantity());
			pr.setOriginalId(order.getId());
			Optional<Produit> produit = produitRepository.findByReference(oi.getRefProduct());
			if ( produit.isPresent() ) {
				pr.setAvailability(produit.get().getAvailability() >= oi.getQuantity() );
			} else {
				pr.setAvailability(false);
			}
			
			produitRequest.add(pr);
		});
		
		 MessageChannel messageChannel = produitRequestStream.outboundResponses();
	        messageChannel.send(MessageBuilder
	                .withPayload(produitRequest)
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
	}
}
