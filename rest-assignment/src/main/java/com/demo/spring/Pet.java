package com.demo.spring;

public class Pet {
	private int petId;
	private String petName;
	private String petType;

	public Pet(int petId, String petName, String petType) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petType = petType;
	}

	public Pet() {
		super();
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

}
