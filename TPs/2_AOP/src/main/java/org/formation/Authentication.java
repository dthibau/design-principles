package org.formation;

import org.springframework.stereotype.Component;

@Component
public class Authentication {

	
	private ThreadLocal<Boolean> authenticated = new ThreadLocal<>();
	
	public void authenticate()  {
		authenticated.set(true);
	}
	public void logout()  {
		authenticated.set(false);
	}
	
	public boolean isAuthenticated()  {
		return authenticated.get() != null ? authenticated.get() : false;
	}
}
