package org.formation.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.formation.OrderStream;
import org.formation.dto.ProduitRequest;
import org.formation.model.Order;
import org.formation.model.OrderRepository;
import org.formation.service.dependencies.Courriel;
import org.formation.service.dependencies.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	OrderStream orderStream;
	
	protected Logger logger = Logger.getLogger(OrderService.class.getName());
	
	public Order processOrder(Order order ) {
		Courriel courriel = new Courriel();
		courriel.setTo(order.getClient().getEmail());
		courriel.setSubject("Merci pour votre commande !");
		courriel.setText("Félicitations " + order.getClient().getPrenom());
		notificationService.sendSimple(courriel);
		
		order = orderRepository.save(order);
		
	
		return order;
	}
	

}
