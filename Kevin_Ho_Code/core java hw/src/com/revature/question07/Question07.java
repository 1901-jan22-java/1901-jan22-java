package com.revature.question07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question07
{
/*
 * sort two employees based on their name, department, and age using the comparator interface
 * */
	public static void main(String[] args)
	{
		List<Employee> employees = new ArrayList<Employee>();
		Employee guy1 = new Employee("A", "C", 20);
		Employee guy2 = new Employee("D", "A", 20);
		Employee guy3 = new Employee("B", "B", 21);
		Employee guy4 = new Employee("C", "D", 19);
		//prints out the employees
		
		employees.add(guy1);
		employees.add(guy2);
		employees.add(guy3);
		employees.add(guy4);

		System.out.println("SORTING BY NAME");
		Collections.sort(employees, new CompareByName());
		System.out.println(toString(employees));
		
		System.out.println("SORTING BY DEPARTMENT");
		Collections.sort(employees, new CompareByDepartment());
		System.out.println(toString(employees));
				
		System.out.println("SORTING BY AGE");
		Collections.sort(employees, new CompareByAge());
		System.out.println(toString(employees));
		
	}
	
	public static String toString(List<Employee> employees)
	{
		String result = "";
        
        for(int i = 0; i < employees.size(); i++)
        	result += "" + employees.get(i).getName() + " " + employees.get(i).getDepartment() + " " + employees.get(i).getAge() + "\n";
    
        return result;
	}
	
}


class Employee
{
	private String name = "";
	private String department = "";
	private int age = 0;
	
	public Employee(String name, String department, int age)
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public Employee()
	{
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}