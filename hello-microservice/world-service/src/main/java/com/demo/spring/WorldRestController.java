package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldRestController {
	
	@GetMapping("/world")
	public String getHello() {
		return "World";
	}

}
