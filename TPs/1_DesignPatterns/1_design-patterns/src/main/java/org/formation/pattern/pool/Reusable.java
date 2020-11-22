package org.formation.pattern.pool;

public class Reusable {

	public long myAttribute=0l;
	
	public Reusable() {
		// Instantiation is long
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
	}

	
	public long callMethod() {
		// Call method is a little long
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		myAttribute += System.currentTimeMillis();
		return myAttribute;
	}


	
	
}
