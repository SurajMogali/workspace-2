package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.demo.spring.Greet;

@Component
public class EmployeeService {
	@Autowired
	private EmpDao dao;

	public String registerEmp(Integer id, String name, String city, double salary) {
		String response= dao.save(new Emp(id,name,city,salary));
		return response;
	}

	public EmpDao getDao() {
		return dao;
	}

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	

}