package org.formation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private EurekaClient discoveryClient;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSendMail() {
		
		
		Courriel courriel = new Courriel("david.thibau@gmail.com","Hello","It is just a test !");
		RestTemplate restTemplate = new RestTemplate();
	
		discoveryClient.
		ResponseEntity<String> response
		  = restTemplate;
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

	}
}
