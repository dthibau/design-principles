package org.formation.pattern.pool;

import java.util.concurrent.Callable;

public class Client implements Callable<Long> {

	int nbTries = 0;
	
	@Override
	public Long call() throws Exception {
		// I need a Reusable Object
		Reusable reusable = _getReusable();

		// To call, its callMethod
		long ret = reusable.callMethod();

		// And return its result
		ReusablePool.getInstance().releaseReusable(reusable);

		return ret;

	}

	private Reusable _getReusable() throws NoMoreObjectAvailableException {
		Reusable ret;
		try {
			ret=ReusablePool.getInstance().getReusable();
			nbTries = 0;
			return ret;
		} catch(NoMoreObjectAvailableException e) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e2) {}
			System.out.println("Client " + this + " will try another " + nbTries + "th time");
			if ( nbTries < 5 ) {
				nbTries++;
				return _getReusable();
			} 
			throw e;
		}

	}
}
