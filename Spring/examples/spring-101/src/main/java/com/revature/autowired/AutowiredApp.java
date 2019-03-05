package com.revature.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredApp {
	
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = (Employee)context.getBean("employee");
		emp.setName("Genesis");
		emp.getDepartment().setName("Training Team");
		
		Employee e2 = (Employee)context.getBean("employee");
		e2.setName("Malika");
		e2.getDepartment().setName("University Partnerships");

		System.out.println(emp);
		System.out.println(e2);
	}
}
