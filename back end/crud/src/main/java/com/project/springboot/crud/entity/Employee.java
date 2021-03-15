package com.project.springboot.crud.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="birth_date")
	private Date birthdate;
	@Column(name="car")
	private boolean car;
	@Column(name="home_address")
	private String homeaddress;
	
	//define constructor
	public Employee() {
		
	}

	public Employee(String name, Date birthdate, boolean car, String homeaddress) {
		this.name = name;
		this.birthdate = birthdate;
		this.car = car;
		this.homeaddress = homeaddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public boolean isCar() {
		return car;
	}

	public void setCar(boolean car) {
		this.car = car;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", car=" + car + ", homeaddress="
				+ homeaddress + "]";
	}
	
	
	
	
}
