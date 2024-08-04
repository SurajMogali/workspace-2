package com.demo.spring.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	public User findbyUserName(String userName);

}
