package com.demo.spring;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainCust {
    public static void main(String[] args) {



       ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);



       Customer customer = (Customer) ctx.getBean("customer");



       System.out.println(customer.getName().getFirstName());
        System.out.println(customer.getEmails());
    }

}