package com.project.springboot.crud.dao;

import java.util.List;

import com.project.springboot.crud.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
