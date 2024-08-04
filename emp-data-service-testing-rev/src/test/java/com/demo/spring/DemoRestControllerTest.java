package com.demo.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

//test dependency injection container created
//creates test environment // w/o this not going to run 
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoRestControllerTest {

	@LocalServerPort
	int port;

	// for accessing web services
	@Autowired
	TestRestTemplate template;

	@Test
	public void testDemoRestController() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/info", String.class);

		Assertions.assertTrue(response.getBody().contains("Rest"));

	}

}
