package org.formation.pattern.adapter;

public class Client {

	private TargetIF service;
	
	
	public double doIt() {
		return service.interfaceMethod();
		
	}


	// Inject Service 
	public TargetIF getService() {
		return service;
	}


	public void setService(TargetIF service) {
		this.service = service;
	}
	
	
}
