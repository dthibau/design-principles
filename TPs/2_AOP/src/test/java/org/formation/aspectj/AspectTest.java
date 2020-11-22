package org.formation.aspectj;

import org.formation.Application;
import org.formation.Authentication;
import org.formation.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AspectTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
    Service service;
	
	@Autowired
    Authentication authentication;
	
	@Before
	public void showContext() {
		for ( String beanName : context.getBeanDefinitionNames() ) {
			if ( context.getBean(beanName).getClass().getName().startsWith("org.formation")) {
				System.out.println("My Spring bean : " + beanName);
			}
		}
	}
    @Test
    public void testAspects() throws Exception {

        service.securedServe();
        authentication.authenticate();
        service.securedServe();      
        service.timedServe();
        service.timedAndSecuredServe();
        authentication.logout();
        service.timedAndSecuredServe();

        
    }
}