package com.demo.spring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.Emp;

@Controller
public class EmpController {

	Map<Integer,Emp> db=new ConcurrentHashMap<>();

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		//db.put(empId, new Emp(empId, name, city, salary));
		return mv;
	}
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView register1() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		//db.put(empId, new Emp(empId, name, city, salary));
		return mv;
	}
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("empId") Integer empId, @RequestParam("name") String name, @RequestParam("city") String city,@RequestParam("salary") Double salary) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		db.put(empId, new Emp(empId, name, city, salary));
		return mv;
	}
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public ModelAndView list() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("list");
		Collection<Emp> data=db.values();
		List<Emp> empList=new ArrayList<>(data);
			
		mv.addObject(empList);
		return mv;
	}
	@RequestMapping(path="/finder",method=RequestMethod.GET)
	public ModelAndView finder1() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("finder");
		
		return mv;
	}
	@RequestMapping(path="/finder",method=RequestMethod.POST)
	public ModelAndView finder(
			@RequestParam("empId")Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("finder");
		Emp emp=db.get(id);
		System.out.println(emp.getName());
			mv.addObject(emp);
		return mv;
	}
	
	
}