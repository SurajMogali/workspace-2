package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class EmpDaoMockImpl implements EmpDao{
	public String save(Emp e) {
		System.out.println("Emp saved");
		return "saved";
	}

}