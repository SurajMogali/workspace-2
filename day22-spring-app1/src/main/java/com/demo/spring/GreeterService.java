package com.demo.spring;

public class GreeterService {

	private Greet greet;

	public void greet() {
		System.out.println(greet.greetMessage());
	}

	public GreeterService(Greet greet) {
		super();
		this.greet = greet;
	}

	public GreeterService() {
		super();
	}

	public Greet getGreet() {
		return greet;
	}

	public void setGreet(Greet greet) {
		this.greet = greet;
	}

}
