package com.revature.question7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question7 {
/*
 * sort two employees based on their name, department, and age using the comparator interface
 * */
	public static void main(String[] args)
	{
		try
		{
			//gets user input
			Scanner input = new Scanner(System.in);
			System.out.println("Enter name");
			String name = input.nextLine();
			System.out.println("Enter department");
			String department = input.nextLine();
			System.out.println("Enter age");
			int age = input.nextInt();
			input.close();
		}
		//if user enters invalid inputs, make them try again
		catch(InputMismatchException e)
		{
			System.out.println("Invalid inputs. Try again.");
		}
	}
}

class Employee
{
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age)
	{
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}