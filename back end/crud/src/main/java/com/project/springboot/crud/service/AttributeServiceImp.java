package com.project.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.crud.dao.AttributeDAO;
import com.project.springboot.crud.entity.Attribute;

@Service
public class AttributeServiceImp implements AttributeService {
	
	private AttributeDAO attributeDAO;
	
	@Autowired
	public AttributeServiceImp(AttributeDAO attributeDAO) {
		this.attributeDAO = attributeDAO;
	}

	@Override
	@Transactional
	public List<Attribute> findAll() {
		return attributeDAO.findAll();
	}

	@Override
	@Transactional
	public Attribute findById(int id) {
		return attributeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Attribute attribute) {
		attributeDAO.save(attribute);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		attributeDAO.deleteById(id);

	}

}
