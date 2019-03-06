package com.revature.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {
	
	private int id;
	private String name;
	
	@Autowired
	private Department department;
	
	public Employee() {
		System.out.println("EMPLOYEE - NO ARGS CONTRUCTOR");
	}

	public Employee(int id, String name, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		System.out.println("EMPL ARGS CONSTRUCTOR");
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		System.out.println("EMP - SET DEPARTMENT");
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee " + id + ") name =" + name + ", department=" + department.getName();
	}
}
