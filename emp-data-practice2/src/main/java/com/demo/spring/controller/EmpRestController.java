package com.demo.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.exception.EmpNotFoundException;
import com.demo.spring.repository.EmpRepository;
import com.demo.spring.util.Message;

@RestController
public class EmpRestController {

	@Autowired
	EmpRepository empRepository;

	@GetMapping(path = "/find/{empId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity findOneEmp(@PathVariable("empId") int id) throws EmpNotFoundException {
		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		} else {
			throw new EmpNotFoundException();
		}

	}

	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Message> saveEmp(@RequestBody Emp e) {
		if (empRepository.existsById(e.getEmpID())) {
			return ResponseEntity.ok(new Message("Emp already exists"));
		} else {
			empRepository.save(e);
			return ResponseEntity.ok(new Message("Emp saved"));

		}

	}

	@DeleteMapping(path = "/delete", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Message> deleteEmp(@RequestBody Emp e) {
		if (empRepository.existsById(e.getEmpID())) {
			empRepository.delete(e);
			return ResponseEntity.ok(new Message("Emp deleted"));

		} else {
			return ResponseEntity.ok(new Message("Emp does not exist"));
		}

	}

	@GetMapping(path = "/list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Emp>> getListEmp() {
		return ResponseEntity.ok(empRepository.findAll());

	}

	@PatchMapping(path = "/update/{empId}/{salary}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Message> updateEmp(@PathVariable("empId") int empId, @PathVariable("salary") double salary)
			throws EmpNotFoundException {
		Optional<Emp> empOp = empRepository.findById(empId);
		if (empOp.isPresent()) {
			empRepository.updateSalary(empId, salary);
			return ResponseEntity.ok(new Message("Sal updated for employee"));

		} else {
			throw new EmpNotFoundException();
		}
	}

}
