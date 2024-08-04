package com.demo.spring;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.demo.spring.entity.Emp;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpRestControllerTest {

	@LocalServerPort
	int port;

	// for accessing web services
	@Autowired
	TestRestTemplate template;
//	@Autowired
//	EmpRepository empRepo;

	@Test
	public void testFindOneEmp() {
		ResponseEntity<Emp> response = template.getForEntity("http://localhost:" + port + "/find/100", Emp.class);
		Assertions.assertTrue(response.getBody().getName().contains("john"));
		Assertions.assertEquals(100, response.getBody().getEmpId());
	}

	@Test
	public void testFindOneEmpFailure() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/find/100", String.class);
		Assertions.assertTrue(response.getHeaders().getContentType().equals(MediaType.APPLICATION_JSON));
	}

	@Test
	public void getEmpListTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity<Void> req = new HttpEntity<>(headers);
		// The exchange method executes the request of any HTTP method and returns
		// ResponseEntity instance
		ResponseEntity<List<Emp>> empList = template.exchange("http://localhost:" + port + "/list", HttpMethod.GET, req,
				new ParameterizedTypeReference<List<Emp>>() {
				});
		Assertions.assertTrue(empList.getBody().size() > 0);
	}
	
	

}