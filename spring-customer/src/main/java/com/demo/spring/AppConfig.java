package com.demo.spring;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.demo.spring"})

public class AppConfig {



   @Bean //method name is a bean name
    public Name custName() {
        Name name = new Name();
        name.setFirstName("suraj");
        name.setLastName("mogali");
        return name;
    }
    
    @Bean
    public List<String> emailList(){
        List<String> emails = new ArrayList<>();
        emails.add("suraj@gmail.com");
        emails.add("raj@gmail.com");
        emails.add("virat@gmail.com");
        return emails;
    }



}