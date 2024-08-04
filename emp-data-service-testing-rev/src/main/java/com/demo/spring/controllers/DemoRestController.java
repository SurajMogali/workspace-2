package com.demo.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.spring.repository.EmpRepository;

@Controller
public class DemoRestController {

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public @ResponseBody String info() {
		return "This is a Rest Service";
	}
	
}
