package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.AppConfig;
import com.demo.spring.GreetService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService es=(EmployeeService)ctx.getBean("employeeService");
		es.registerEmp(100, "Suraj","Hospet", 30000);
	}

}