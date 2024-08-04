package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context3.xml");
		GreeterService g = ctx.getBean(GreeterService.class, "greetserv");
		g.greet();

		GreeterService g1 = ctx.getBean(GreeterService.class, "greetserv");
		g.greet();
		
		

		System.out.println(g == g1);
		
		

	}

}