package com.revature.question7;


public class Question7 {
/*
 * sort two employees based on their name, department, and age using the comparator interface
 * */
	public static void main(String[] args)
	{
		Employee guy1 = new Employee("Nomuraa", "Square Enixx", 21);
		Employee guy2 = new Employee("Nomura", "Square Enix", 20);
		//prints out the employees
		System.out.println(	guy1.getName() + " " + 
							guy1.getDepartment() + " " + 
							guy1.getAge());
		System.out.println(	guy2.getName() + " " + 
							guy2.getDepartment() + " " + 
							guy2.getAge());

		System.out.println(compare(guy1, guy2));
		System.out.println(compare(guy1, guy2));
		System.out.println(compare(guy1, guy2));
		
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