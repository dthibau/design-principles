package org.formation.service;

import org.formation.model.Order;
import org.formation.model.OrderRepository;
import org.formation.service.dependencies.Courriel;
import org.formation.service.dependencies.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	

	
	public Order processOrder(Order order ) {
		
		return orderRepository.save(order);
	}
}
