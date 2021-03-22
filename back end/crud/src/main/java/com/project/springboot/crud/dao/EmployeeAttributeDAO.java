package com.project.springboot.crud.dao;

import java.util.List;

public interface EmployeeAttributeDAO {
	
	public List<Integer> getAttrByEmpId(int employeeId);
	
	public void save(int employeeId,List<Integer> attributesList);
	
	public void deleteById(int employeeId);
	
	public List<Integer> getEmpByAttrId(int attributeId);

}
