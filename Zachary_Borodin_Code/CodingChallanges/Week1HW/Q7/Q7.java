//Zachary Borodin
package com.revature.hw1.Q7;
//sort 2 empoyees based on their name, department, and age
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q7 {
	public static void main(String[] args) {
		List<Employee> e = new ArrayList<>();
		
		e.add(new Employee("Zach","G-dep", 23));
		e.add(new Employee("John", "A-dep", 25));
		e.add(new Employee("Bob","C-dep", 19));
		
		System.out.println("Sorted by Name");
		Collections.sort(e, new CompareByName());
		System.out.println(e+"\n");
		
		System.out.println("Sorted by Department");
		Collections.sort(e, new CompareByDep());
		System.out.println(e+"\n");
		
		System.out.println("Sorted by Age");
		Collections.sort(e, new CompareByAge());
		System.out.println(e+"\n");
		
		
	}

}

class Employee{
	private String  name;
	private String department;
	private int age;
	
	
	public Employee() {
		this.name = "default name";
		this.department = "default department";
		this.age = 0;
	}
	//constructor with parameters
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		//checks for a valid age
		if(age > 0 && age < 100) {
			this.age = age;
		}
		else {
			//System.out.println("Invalid age");
			this.age = 20; //default age
		}
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
	@Override
	public String toString() {
		return  name + ", " + department + ", " + age;
	}	
	
	
}

 class CompareByName implements Comparator<Employee>{
	 //compares by name
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
	
}
 
 class CompareByDep implements Comparator<Employee>{
	 //compare by department
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
	 
 }
 
 class CompareByAge implements Comparator<Employee>{
	 //compares by age
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getAge() - e2.getAge();
	}
	 
 }
