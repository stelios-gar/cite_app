package com.project.springboot.crud.dao;

import java.util.List;

import com.project.springboot.crud.entity.Attribute;

public interface AttributeDAO {
	
	public List<Attribute> findAll();
	
	public Attribute findById(int id);
	
	public void save(Attribute attribute);
	
	public void deleteById(int id);
}
