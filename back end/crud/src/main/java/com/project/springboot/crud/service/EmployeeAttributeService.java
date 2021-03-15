package com.project.springboot.crud.service;

import java.util.List;

public interface EmployeeAttributeService {

	public List<Integer> findById(int employeeId);
	
	public void save(int employeeId,List<Integer> attributesList);
	
	public void deleteById(int employeeId);
}
