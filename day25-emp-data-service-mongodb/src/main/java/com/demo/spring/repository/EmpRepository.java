package com.demo.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends MongoRepository<Emp, Integer>{
	 @Query("UPDATE Emp e set e.salary=:salary where empId=:empId ") // jpql query
	    
	    @Transactional // declarative transaction
	    public int updateSalary(int empId, double salary);
}
