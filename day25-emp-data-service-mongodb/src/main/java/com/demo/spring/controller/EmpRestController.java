package com.demo.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.demo.spring.util.Message;

@RestController
public class EmpRestController {

	@Autowired
	private EmpRepository empRepo;

	@RequestMapping(path = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> save(@RequestBody Emp e) {

		if (empRepo.existsById(e.getEmpId())) {
			return ResponseEntity.ok(new Message("Emp Exists"));
		} else {
			empRepo.save(e);
			return ResponseEntity.ok(new Message("Emp Saved"));
		}
	}
	
	
	
	@GetMapping(path = "/find/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findOneEmp(@PathVariable("empId") int id) {

		// optional wraps object ,Optional was created because to avoid null
		Optional<Emp> empOp = empRepo.findById(id);
		if (empOp.isPresent()) // all the CRUD methods are present in JpaRepo
		{
			return ResponseEntity.ok(empOp.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("Emp not found with Id " + id));
		}

	}
	
	
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getEmpList() {

		return ResponseEntity.ok(empRepo.findAll());

	}
	
	
	@DeleteMapping(path = "/delete/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> deleteEmp(@PathVariable("empId") int id) {
        if (empRepo.existsById(id)) {
            empRepo.deleteById(id);
            return ResponseEntity.ok(new Message("Emp deleted"));
        } else {
            return ResponseEntity.ok(new Message("Emp doesnt exist"));
        }
    }
	
	@PatchMapping(path = "/update1/{empId}/{salary}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> update1(@PathVariable("empId") int empId ,@PathVariable("salary") int salary ) {
        if(empRepo.existsById(empId)) {
            
            empRepo.updateSalary(empId,salary);
            return ResponseEntity.ok(new Message("Emp is updated.."));
        }else {
            return ResponseEntity.ok(new Message("Emp data deleted.."));
        }
	} 
	
	
	
	
	
	
}