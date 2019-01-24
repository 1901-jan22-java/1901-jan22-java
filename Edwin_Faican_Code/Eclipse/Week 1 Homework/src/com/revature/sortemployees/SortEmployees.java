package com.revature.sortemployees;

public class SortEmployees {
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Bob", 21, "The Builder");
		Employee e2 = new Employee("Joe", 30, "Autotech");
		
		SortName sortName = new SortName();
		SortAge sortAge = new SortAge();
		SortDepartment sortDepo = new SortDepartment();
		
		int name = sortName.compare(e1, e2);
		int age = sortAge.compare(e1, e2);
		int depo = sortDepo.compare(e1, e2);
		
		if(name <= 0) {
			System.out.println(e1.getName() + ", " + e2.getName());
		} else{
			System.out.println(e2.getName() + ", " + e1.getName());
		}
		
		if(age <= 0) {
			System.out.println(e1.getName() + ", " + e2.getName());
		} else{
			System.out.println(e2.getName() + ", " + e1.getName());
		}
		
		if(depo <= 0) {
			System.out.println(e1.getName() + ", " + e2.getName());
		} else{
			System.out.println(e2.getName() + ", " + e1.getName());
		}
	
	}
}
