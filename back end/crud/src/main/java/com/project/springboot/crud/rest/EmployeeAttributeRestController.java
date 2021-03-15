package com.project.springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.crud.service.EmployeeAttributeService;

@RestController
@RequestMapping("/api")
public class EmployeeAttributeRestController {

private EmployeeAttributeService employeeAttributeService;
	

	@Autowired
	public EmployeeAttributeRestController(EmployeeAttributeService employeeAttributeService) {
		this.employeeAttributeService = employeeAttributeService;
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/employees-attribute/{employeeId}")
	public List<Integer> getAttributes(@PathVariable int employeeId){
		List<Integer> attributes;
		
		attributes = employeeAttributeService.findById(employeeId);
		return attributes;
	}
	
//	@CrossOrigin(origins="http://localhost:4200")
//	@RequestMapping(value="/employees-attribute/{employeeId}", method=RequestMethod.OPTIONS)
//	public void getAttributes2(@PathVariable int employeeId){
//
//	}

	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/employees-attribute/{employeeId}")
	public void addAttributes(@PathVariable int employeeId,@RequestBody List<Integer> attributesList) {
		employeeAttributeService.save(employeeId, attributesList);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/employees-attribute/{employeeId}")
	public void deleteById(@PathVariable int employeeId) {
		employeeAttributeService.deleteById(employeeId);
	}
	
	
}
