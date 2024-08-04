package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageRestController {
	@Autowired
	RestTemplate template;
	
	
	@GetMapping("/greet")
	public String getGreet() {
		String hello=template.getForObject("http://localhost:8081/hello",String.class);
		String world=template.getForObject("http://localhost:8081/hello",String.class);
		return hello+world;
	}

}
