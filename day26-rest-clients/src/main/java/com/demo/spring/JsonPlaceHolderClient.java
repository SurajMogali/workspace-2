package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class JsonPlaceHolderClient {
	public static void main(String[] args) {

		final String BASE_URL="https://jsonplaceholder.typicode.com/posts";
		RestTemplate restTemplate=new RestTemplate();
		// exchange starts

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> req = new HttpEntity<>(headers);

		ResponseEntity<PostDTO> resp2 = restTemplate.exchange(BASE_URL+"/2", HttpMethod.GET, req,PostDTO.class);
				

		System.out.println(resp2.getBody());
	}

}