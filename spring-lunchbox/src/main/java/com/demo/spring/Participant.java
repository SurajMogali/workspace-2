package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Participant {

	@Autowired
	private String name;
	
	@Autowired
	Lunchbox lunchbox;

	public Participant() {
		super();
	}

	public Participant(String name, Lunchbox lunchbox) {
		super();
		this.name = name;
		this.lunchbox = lunchbox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lunchbox getLunchbox() {
		return lunchbox;
	}

	public void setLunchbox(Lunchbox lunchbox) {
		this.lunchbox = lunchbox;
	}

}
