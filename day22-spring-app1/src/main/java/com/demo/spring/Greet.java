package com.demo.spring;

public interface Greet {
	public String greetMessage();
}

class GoodMorning implements Greet
{

	@Override
	public String greetMessage() {
		
		return "Good Morning";
	}
	
	
}