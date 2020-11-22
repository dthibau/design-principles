package org.formation.pattern.adapter;

public class Main {

	public static void main(String[] args) {
		
		Client client = new Client();
		
		// Inject the good service

		
		
		assert (client.doIt() == Math.PI);

		System.out.println("Exiting Normally ! But do you have enabled assertions ??");

	}

}
