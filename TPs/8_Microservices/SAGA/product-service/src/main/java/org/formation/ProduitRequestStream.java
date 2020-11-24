package org.formation;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProduitRequestStream {

	String INPUT = "orders-in";
	String OUTPUT = "availability-out";
	
	@Input(INPUT)
	SubscribableChannel inboundRequests();
	
	@Output(OUTPUT)
	MessageChannel outboundResponses();
}
