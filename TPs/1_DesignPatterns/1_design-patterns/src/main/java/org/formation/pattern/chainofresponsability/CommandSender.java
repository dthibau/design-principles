package org.formation.pattern.chainofresponsability;

public class CommandSender {

	CommandChain chain;
	
	
	public CommandChain getChain() {
		return chain;
	}


	public void setChain(CommandChain chain) {
		this.chain = chain;
	}


	public void sendCommand(String commande) {
		// I'd like to send my commande to all the handlers in the chain without knowing them
	}
}
