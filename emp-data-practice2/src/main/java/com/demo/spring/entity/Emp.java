package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="EMPLOYEE")
@XmlRootElement
public class Emp {

	@Id
	private Integer empID;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String city;

	@Column(name = "SALARY")
	private Double salary;

	public Emp() {
		super();
	}

	public Emp(Integer empID, String name, String city, Double salary) {
		super();
		this.empID = empID;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public Integer getEmpID() {
		return empID;
	}

	public void setEmpID(Integer empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
