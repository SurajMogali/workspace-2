package com.demo.spring;

public class Emp {

	private Integer id;
	private String name;
	private String address;
	private double salary;

	public Emp() {

	}

	public Emp(Integer empId, String name, String address, double salary) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}