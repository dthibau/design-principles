package org.formation.service.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
	
    public String sendSimple(Courriel email) {
//		return restTemplate.postForObject("http://notification-service/sendSimple", email, String.class);
		
		return cbFactory.create("sendsimple").run(() -> restTemplate.postForObject("http://notification-service/sendSimple", email, String.class), throwable -> { System.out.println("FALLBACK"); return "fallback"; });
	}
}
