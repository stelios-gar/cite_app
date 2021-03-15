package com.project.springboot.crud.rest;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.crud.dao.EmployeeAttributeDAOHibernate;
import com.project.springboot.crud.entity.Employee;
import com.project.springboot.crud.service.EmployeeAttributeService;
import com.project.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	//add mapping for GET /employees/{employeeId}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found - "+ employeeId);
		}
		
		return employee;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/employees")
	public Employee editEmployee(@RequestBody Employee employee) {
		
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteById(employeeId);
	}
	
}
