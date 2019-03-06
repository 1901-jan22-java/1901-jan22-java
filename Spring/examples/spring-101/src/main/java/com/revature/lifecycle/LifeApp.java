package com.revature.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Life life = (Life) context.getBean("lifecycle");
		System.out.println("Doing things with my lifecycle class " + life.getLifecycle());
		((ConfigurableApplicationContext)context).close();
	}
}
