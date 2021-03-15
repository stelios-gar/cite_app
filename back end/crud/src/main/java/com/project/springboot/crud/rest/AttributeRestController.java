package com.project.springboot.crud.rest;

import java.util.List;

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

import com.project.springboot.crud.entity.Attribute;
import com.project.springboot.crud.service.AttributeService;

@RestController
@RequestMapping("/api")
public class AttributeRestController {
	
	private AttributeService attributeService;
	
	@Autowired
	public AttributeRestController(AttributeService attributeService) {
		this.attributeService = attributeService;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/attributes")
	public List<Attribute> findAll(){
		return attributeService.findAll();
	}
	
	//add mapping for GET /attributes/{attributeId}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/attributes/{attributeId}")
	public Attribute getAttribute(@PathVariable int attributeId) {
		
		Attribute attribute = attributeService.findById(attributeId);
		
		if(attribute == null) {
			throw new RuntimeException("Attribute id not found - "+ attributeId);
		}
		
		return attribute;
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/attributes")
	public Attribute addAttribute(@RequestBody Attribute attribute) {
		
		attribute.setId(0);
		
		attributeService.save(attribute);
		
		return attribute;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/attributes")
	public Attribute editAttribute(@RequestBody Attribute attribute) {
		
		attributeService.save(attribute);
		
		return attribute;
	} 
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/attributes/{attributeId}")
	public void deleteAttribute(@PathVariable int attributeId) {
		attributeService.deleteById(attributeId);
	}
	
	
	
	
	
	
	
}
