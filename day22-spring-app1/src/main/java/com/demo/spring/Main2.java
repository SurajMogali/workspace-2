package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("context2.xml");
	Emp emp1 = ctx.getBean(Emp.class,"emp");
	System.out.println(emp1.getName().getFirstName()+""+emp1.getName().getLastName());
	System.out.println(emp1.getEmpId());
	System.out.println(emp1.getAddress().getCity());
	System.out.println(emp1.getSalary());

	}

}