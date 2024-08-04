package com.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.demo.spring.util.Message;

@RestController
public class EmpRestController {

	@Autowired
	// using emp repo to call
	// injecting emp respository //injecting obj at runtime
	EmpRepository empRepository;

	// /find/100----->empId=100
	// @RequestMapping(path="/find/{empId}", method = RequestMethod.GET)
	// producers-->wt representation method can produce --Json
	@GetMapping(path = "/find/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
//	ResponseEntity represents the whole HTTP response
	public ResponseEntity findOneEmp(@PathVariable("empId") int id) throws EmpNotFoundException {
		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		} else {
			throw new EmpNotFoundException();
		}
	}

	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getEmpList() {

		return ResponseEntity.ok(empRepository.findAll());

	}

	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	// json data present in request body
	public ResponseEntity<Message> saveEmp(@RequestBody Emp e) {
		if (empRepository.existsById(e.getEmpId())) {
			return ResponseEntity.ok(new Message("emp alreadye exists"));
		} else {
			empRepository.save(e);
			return ResponseEntity.ok(new Message("emp saved"));
		}

	}

	// get method should not alter data base
	@DeleteMapping(path = "/delete/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteEmp(@PathVariable("empId") int id) {
		if (empRepository.existsById(id)) {
			empRepository.deleteById(id);
			return ResponseEntity.ok(new Message("Emp by id " + id + " deleted"));
		} else {
			return ResponseEntity.ok(new Message("Emp Not found"));
		}
	}

	@PatchMapping(path = "/update/{empId}/{salary}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateEmp(@PathVariable("empId") int id, @PathVariable("salary") double sal) {

		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			empRepository.updateSalary(id,sal);
			return ResponseEntity.ok(new Message("Employee updated"));
		} else {
			return ResponseEntity.ok(new Message("Employee not found"));

		}

	}
	@ExceptionHandler(EmpNotFoundException.class)
	public ResponseEntity<Message> handleEmpNotfound(EmpNotFoundException ex){
		return ResponseEntity.ok(new Message("emp not found"));
		
	}
	
}
