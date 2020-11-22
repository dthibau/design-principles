package org.formation.pattern.chainofresponsability;

import java.util.LinkedList;
import java.util.List;

public class CommandChain {

	private List<CommandHandler> chain = new LinkedList<CommandHandler>();
	private int i=0;
	
	public CommandChain() {
		chain.add(new ConcreteCommandHandler1());
		chain.add(new ConcreteCommandHandler2());
		chain.add(new ConcreteCommandHandler1());
	}
	public CommandHandler getFirst() {
		return chain.get(0);
		
	}
	
	public CommandHandler getNext() {
		i++;
		if ( i< chain.size() ) {
			return chain.get(i);
		}
		return null;
		
	}
}
