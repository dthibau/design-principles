package org.formation.controller;

import java.util.logging.Logger;

import org.formation.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {


	@Autowired
	EmailService emailService;
	
	protected Logger logger = Logger.getLogger(NotificationController.class.getName());
	
	@RequestMapping(path = "/sendSimple", method = RequestMethod.POST)
	public String sendSimpleMessage(@RequestBody Email email) {
	
		logger.info("About to send a mail");
		emailService.sendSimpleMessage(email.getTo(), email.getSubject(), email.getText());
		
		logger.info("Mail sent");
		return "OK";
		
	}
}
