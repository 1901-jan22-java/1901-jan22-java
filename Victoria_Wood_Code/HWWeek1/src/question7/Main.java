package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("victoria", "cs", 22));
		list.add(new Employee("rihanna", "music or so we thought", 30));
		list.add(new Employee("kim k", "social media", 38));
		
		EmployeeComparators.CompareByAge age = new EmployeeComparators.CompareByAge();
		EmployeeComparators.CompareByDepartment department = new EmployeeComparators.CompareByDepartment();
		EmployeeComparators.CompareByName name = new EmployeeComparators.CompareByName();
		
		Collections.sort(list, age);
		
		System.out.println("Employees sorted by Name: \n");
		for(Employee e: list) {
			System.out.println(e.getAge() +" " + e.getName() + " " + e.getDepartment());
		}
		
		Collections.sort(list, department);
		
		System.out.println("\nEmployees sorted by Department: \n");
		for(Employee e: list) {
			System.out.println(e.getDepartment() + " " + e.getName() + " " + e.getAge());
		}

		
		Collections.sort(list, name);
		
		System.out.println("\nEmployees sorted by Name: \n");
		for(Employee e: list) {
			System.out.println(e.getName() + " " + e.getDepartment() + " " + e.getAge());
		}

		

	}

}
