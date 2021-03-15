package com.project.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.crud.dao.EmployeeAttributeDAO;

@Service
public class EmployeeAttributeServiceImp implements EmployeeAttributeService {

	private EmployeeAttributeDAO employeeAttributeDAO;
	
	
	@Autowired
	public EmployeeAttributeServiceImp(EmployeeAttributeDAO employeeAttributeDAO) {
		this.employeeAttributeDAO = employeeAttributeDAO;
	}

	@Override
	@Transactional
	public List<Integer> findById(int employeeId) {
		
		return employeeAttributeDAO.findById(employeeId);
	}

	@Override
	@Transactional
	public void save(int employeeId, List<Integer> attributesList) {
		
		employeeAttributeDAO.save(employeeId, attributesList);

	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		
		employeeAttributeDAO.deleteById(employeeId);
	}

}
