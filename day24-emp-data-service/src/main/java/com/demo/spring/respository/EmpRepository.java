 package com.demo.spring.respository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;



import com.demo.spring.entity.Emp;



public interface EmpRepository extends JpaRepository<Emp, Integer> {



   @Query("UPDATE Emp e set e.salary=:salary where empId=:empId ") // jpql query
    @Modifying // because we have modifying query
    @Transactional // declarative transaction
    public int updateSalary(int empId, double salary);



}