package com.revature.question07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {
	
	private String name;
	private String department;
	private Integer age;
	
	public Employee(String name, String department, Integer age) {
		super();
		this.name = name;
		this.department = department;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		Employee a = new Employee("John", "Finance", 49);
		Employee b = new Employee("Peter", "Wealth Management", 34);
		Employee c = new Employee("Andy", "Finance", 26);
		Employee d = new Employee("Jessica", "Legal", 52);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(a);
		employees.add(b);
		employees.add(c);
		employees.add(d);
		
		
		Collections.sort(employees, new SortByAge());
		
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).getAge());
		}
		
		Collections.sort(employees, new SortByDepartment());
		
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).getDepartment());
		}
		
		Collections.sort(employees, new SortByName());
		
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).getName());
		}
	}
}

class SortByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}
}

class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class SortByDepartment implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
}


