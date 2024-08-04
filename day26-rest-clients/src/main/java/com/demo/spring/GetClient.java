package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		String response = restTemplate.getForObject("http://localhost:8080/find/100",String.class);

		System.out.println(response);

		EmpDTO data = restTemplate.getForObject("http://localhost:8080/find/100", EmpDTO.class);

		System.out.println(data.getName() + " " + data.getSalary());

		ResponseEntity<String> resp = restTemplate.getForEntity("http://localhost:8080/find/100", String.class);

		System.out.println(resp.getBody());

		// exchange starts

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_XML_VALUE);

		HttpEntity<Void> req = new HttpEntity<>(headers);

		ResponseEntity<String> resp2 = restTemplate.exchange("http://localhost:8080/find/100", HttpMethod.GET, req,
				String.class);

		System.out.println(resp2.getBody());
	}

}