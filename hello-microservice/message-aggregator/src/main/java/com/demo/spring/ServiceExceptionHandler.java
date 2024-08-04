package com.demo.spring;

import java.net.ConnectException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {
	
	@ExceptionHandler(ConnectException.class)
	public String handleConnectexception() {
		return "server not found";
	}

}
