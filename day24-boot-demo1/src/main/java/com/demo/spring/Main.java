package com.demo.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws JsonProcessingException
	{
		ObjectMapper objMapper =new ObjectMapper();
		
		Emp emp=new Emp(100,"John","Bangalore",65000.0);
		
		String jsonData=objMapper.writeValueAsString(emp);
		
		System.out.println(jsonData);
		
		String jsonString ="{\"empId\":100,\"name\":\"John\",\"city\":\"Bangalore\",\"salary\":65000.0}";
		
		Emp e2= objMapper.readValue(jsonString, Emp.class);
		
		System.out.println(e2.getName());
		
	}
}