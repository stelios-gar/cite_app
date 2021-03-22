package com.project.springboot.crud.service;

import java.util.List;

public interface EmployeeAttributeService {

	public List<Integer> getAttrByEmpId(int employeeId);
	
	public void save(int employeeId,List<Integer> attributesList);
	
	public void deleteById(int employeeId);
	
	public List<Integer> getEmpByAttrId(int attributeId);

}
