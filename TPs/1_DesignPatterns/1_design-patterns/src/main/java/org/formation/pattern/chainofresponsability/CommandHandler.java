package org.formation.pattern.chainofresponsability;

public abstract class CommandHandler {

	/**
	 * True, command is fully handled.
	 * @param commande
	 * @return
	 */
	public abstract boolean handleCommand(String commande);
}
