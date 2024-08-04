package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class DecoratedWriter implements Writer {

	@Override
	public void write(String message) {
		System.out.println("This is Decorated  Writer");
		
	}

	
}