package com.demo.spring;

import java.util.Set;

class Owner {
	private int ownerId;
	private String ownerName;
	private Set<Pet> pets;

	public Owner(int ownerId, String ownerName, Set<Pet> pets) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.pets = pets;
	}

	public Owner() {
		super();
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
