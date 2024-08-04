package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WriterMain {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		WriterApp writer = (WriterApp) ctx.getBean("writerApp");

		writer.print("Hello Spring");
	}

}