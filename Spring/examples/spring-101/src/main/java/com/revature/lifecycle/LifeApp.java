package com.revature.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeApp {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Life l = (Life) ac.getBean("lifecycle");
		
		System.out.println("Doing things with my life cycle class " + l);
		
	}
	
}
