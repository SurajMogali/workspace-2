package com.demo.spring;

import java.util.List;

public class Trainer {

	private String name;
	private List<Participant> participants;

	public Trainer() {
		super();
	}

	public Trainer(String name, List<Participant> participants) {
		super();
		this.name = name;
		this.participants = participants;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}
