package org.formation;

import org.formation.aspectj.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Service {
	private static final Logger logger = LoggerFactory.getLogger(Service.class);
	
    @Secured(isLocked = true)
    public void securedServe() throws InterruptedException {
    	logger.info("secureServe executing");
    	serve();
    }
    
//    @LogExecutionTime
    public void timedServe() throws InterruptedException {
    	logger.info("timedServe executing");
    	serve();
    }
    
    @Secured(isLocked = true)
//    @LogExecutionTime
    public void timedAndSecuredServe() throws InterruptedException {
    	logger.info("timedAndSecuredServe executing");
    	serve();
    }
    
    
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }
}
