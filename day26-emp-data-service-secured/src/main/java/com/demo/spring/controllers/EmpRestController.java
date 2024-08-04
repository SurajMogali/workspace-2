package com.demo.spring.controllers;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Message;
import com.demo.spring.entity.Emp;
import com.demo.spring.respository.EmpRepository;

@RestController
public class EmpRestController {

	@Autowired
	EmpRepository empRepository; // injection
	// find/100-->empId=100

	// @RequestMapping(path = "/find/{empId}", method = RequestMethod.GET)
	@GetMapping(path = "/find/{empId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity findOneEmp(@PathVariable("empId") int id) {

		// optional wraps object ,Optional was created because to avoid null
		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) // all the CRUD methods are present in JpaRepo
		{
			return ResponseEntity.ok(empOp.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("Emp not found with Id " + id));
		}

	}

	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getEmpList() {

		return ResponseEntity.ok(empRepository.findAll());

	}
	
	
	

	// converts to JSON
	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveEmp(@RequestBody Emp e) {
		if (empRepository.existsById(e.getEmpId())) {
			return ResponseEntity.ok(new Message("Emp Already Exists"));
		} else {
			empRepository.save(e);
			return ResponseEntity.ok(new Message("Emp saved"));
		}
	}
	
	@DeleteMapping(path = "/delete/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> deleteEmp(@PathVariable("empId") int id) {
        if (empRepository.existsById(id)) {
            empRepository.deleteById(id);
            return ResponseEntity.ok(new Message("Emp deleted"));
        } else {
            return ResponseEntity.ok(new Message("Emp doesnt exist"));
        }
    }
	
	@PutMapping (path = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> updateEmp(@RequestBody Emp e){
         if(empRepository.existsById(e.getEmpId()))
            {
                empRepository.save(e);    
                return ResponseEntity.ok(new Message("Employee Updated Successfully"));
            }
            else {
                return ResponseEntity.ok(new Message("Employee not Found"));
            }
    }
	
	@PatchMapping(path = "/update1/{empId}/{salary}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> update1(@PathVariable("empId") int empId ,@PathVariable("salary") int salary ) {
        if(empRepository.existsById(empId)) {
            
            empRepository.updateSalary(empId,salary);
            return ResponseEntity.ok(new Message("Emp is updated.."));
        }else {
            return ResponseEntity.ok(new Message("Emp data deleted.."));
        }
    }
	
	
	
	
	
	
	

}