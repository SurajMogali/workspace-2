package com.demo.spring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.spring.util.Message;

@ControllerAdvice
public class EmpNotFoundException extends Exception {
	
	public ResponseEntity<Message> handleEmpNotFound(EmpNotFoundException ex) {
		return ResponseEntity.ok(new Message("Emp not found"));
	}

}
