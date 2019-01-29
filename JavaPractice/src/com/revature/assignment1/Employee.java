package com.revature.assignment1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Question 7
 * 
 * @author Sanford
 *
 */

public class Employee implements Comparable<Employee> {
	
	/* Variables */
	private String name;
	private String email;
	private BigInteger age;
	
	/* Constructors */
	public Employee() {
		setAge(0);
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public Employee(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Employee(String name, String email, int age) {
		this.name = name;
		this.email = email;
		setAge(age);
	}
	
	public Employee(String name, String email, long age) {
		this.name = name;
		this.email = email;
		setAge(age);
	}
	
	public Employee(String name, String email, BigInteger age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	/* Methods */
	
	/* Comparators */
	public static class EmployeeComparator implements Comparator<Employee> {
		
		@Override
		public int compare(Employee a, Employee b) {
			int nc = a.name.compareTo(b.name);
			int ec = a.email.compareTo(b.email);
			int ac = a.age.compareTo(b.age);
			return (nc == 0) ? ((ec == 0) ? ac :ec) : nc;
		}
		
	}

	/* Overrided */
	@Override
	public int compareTo(Employee o) {
		return (new EmployeeComparator()).compare(this, o);
	}
	
	@Override
	public String toString() {
		return name + ";" + email + ";" + age;
	}
	
	/* Accessors and Mutators */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getAge() {
		return age;
	}

	public void setAge(int age) {
		setAge(BigInteger.valueOf(age));
	}
	
	public void setAge(long age) {
		setAge(BigInteger.valueOf(age));
	}
	
	public void setAge(BigInteger age) {
		if(age.compareTo(BigInteger.ZERO) < 0) return;
		this.age = age;
	}
	
}

// Make into JUnit?
class EmployeeTest {
	
	public static void main(String[] args) {
		SortedSet<Employee> s = new TreeSet<>();
		
		s.addAll(Arrays.asList(
				new Employee("a", "a", 10), 
				new Employee("a", "a", 20), 
				new Employee("a", "a", 30), 
				new Employee("a", "a", 40)
				));
		
		System.out.println(s);
	}
	
}
