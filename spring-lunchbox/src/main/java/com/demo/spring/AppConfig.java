package com.demo.spring;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.demo.spring"})

public class AppConfig {



   @Bean 
   public List<Participant> pList(){
	   List<Participant> list=new ArrayList<>();
	   
	   list.add(new Participant("Jenny",new Lunchbox("Idli","vada")));
	   list.add(new Participant("Sam",new Lunchbox("Rice","rasam")));
	   list.add(new Participant("Sarah",new Lunchbox("Biryani","Chicken")));
	   return list;
	   
   }
   
   @Bean
   public String trainerName() {
	   return "John";
	   
	   
   }
    



}