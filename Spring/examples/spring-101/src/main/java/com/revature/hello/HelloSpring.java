package com.revature.hello;

public class HelloSpring {
	
	/*
	 * This will be our first Spring bean!
	 * A Spring bean is simply a class managed by the 
	 * spring container
	 * We will allow the Spring container aka the IoC 
	 * container to instantiate this class, and inject
	 * its dependencies 
	 * 
	 * Spring beans must follow the standard convention 
	 * of having a public no-args contructor. In addition, 
	 * if there are instance variables that we will use 
	 * setter injection for, we must follow the standard 
	 * naming convention setVarName(). 
	 */
	
	private String messageString;
	
	public HelloSpring() {}

	public HelloSpring(String messageString) {
		super();
		this.messageString = messageString;
	}

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String message) {
		this.messageString = message;
	}
	
	

}
