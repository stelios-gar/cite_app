package com.project.springboot.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeeattribute")
public class EmployeeAttribute {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="attribute_id")
	private int attributeId;

	
	public EmployeeAttribute() {
		
	}
	
	public EmployeeAttribute(int employeeId, int attributeId) {
		this.employeeId = employeeId;
		this.attributeId = attributeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	@Override
	public String toString() {
		return "EmployeeAttribute [id=" + id + ", employeeId=" + employeeId + ", attributeId=" + attributeId + "]";
	}
	
	

}
