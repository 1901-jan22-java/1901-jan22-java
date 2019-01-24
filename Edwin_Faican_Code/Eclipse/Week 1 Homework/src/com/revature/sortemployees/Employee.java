package com.revature.sortemployees;

import java.util.Comparator;

public class Employee{
	private String name;
	private int age;
	private String department;
	
	public Employee(String name, int age, String department) {
		this.setName(name);
		this.setAge(age);
		this.setDepartment(department);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}

class SortAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge()- o2.getAge();
	}
	
}

class SortName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

class SortDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
	
}
