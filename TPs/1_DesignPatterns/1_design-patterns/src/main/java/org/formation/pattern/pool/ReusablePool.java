package org.formation.pattern.pool;

public class ReusablePool {

	private static ReusablePool instance;
	
	private int maxPoolSize = 10;
	
	
	private NoMoreObjectAvailableException REUSABLE_EXCEPTION = new NoMoreObjectAvailableException(); 
	
	private ReusablePool() {
	}

	public static ReusablePool getInstance() {
		if ( instance == null ) {
			instance = new ReusablePool();
		}
		return instance;
	}
	
	public Reusable getReusable() throws NoMoreObjectAvailableException {
		
		return null;
		
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	
	public void releaseReusable(Reusable reusable) {

	}

	/**
	 * Has side effect to initialize the pool.
	 * @param maxPoolSize
	 */
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
		
	}
	
	
}
