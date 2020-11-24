package org.formation;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OrderStream {

	String OUTPUT_ORDER = "order-out";
	String INPUT_AVAILABILITY = "availability-response";
	String INPUT_AUTHORIZATION = "authorization-response";
	
	@Output(OUTPUT_ORDER)
	MessageChannel outboundProductRequest();
	
	@Input(INPUT_AVAILABILITY)
	SubscribableChannel inboundAvailability();
	
	@Input(INPUT_AUTHORIZATION)
	SubscribableChannel inboundAuthorization();
	
}
