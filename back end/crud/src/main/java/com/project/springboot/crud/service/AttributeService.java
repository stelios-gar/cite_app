package com.project.springboot.crud.service;

import java.util.List;

import com.project.springboot.crud.entity.Attribute;

public interface AttributeService {
	public List<Attribute> findAll();
	
	public Attribute findById(int id);
	
	public void save(Attribute employee);
	
	public void deleteById(int id);
}
