package com.revature.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		//The following uses the new keyword, therefore does not rely on IoC
		HelloSpring spring = new HelloSpring();
		System.out.println(spring.getMessageString());
		
		//We must use our Application context!
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		spring = (HelloSpring) context.getBean("thisIsABean");
		System.out.println(spring.getMessageString());
	}

}
