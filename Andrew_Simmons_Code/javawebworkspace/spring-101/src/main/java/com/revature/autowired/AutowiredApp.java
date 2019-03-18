package com.revature.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Employee emp = (Employee)context.getBean("employee");
		/*
		Employee emp = new Employee();
		
		This will not allow us to even access the department 
		field of our employee because we have never instantiated one
		
		We allow Spring to resolve all dependencies of our 
		objects so that we do not need to worry about them when 
		instantiating 
	*/
		emp.setName("Genesis");
		emp.getDepartment().setName("Training Team");
		
		Employee e2 = (Employee)context.getBean("employee");
		e2.setName("Malika");
		e2.getDepartment().setName("University Partnerships");
		
		System.out.println(emp);
		System.out.println(e2);
			
	}

}