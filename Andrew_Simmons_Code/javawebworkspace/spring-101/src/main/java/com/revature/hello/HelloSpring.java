package com.revature.hello;

public class HelloSpring {
	
	
	/*
	 * This will be our first Spring bean!
	 * A Spring bean is simply a class managed by the spring container
	 * We will allow the Spring container aka the IoC
	 * container to instantiate this class, and inject its dependencies
	 * 
	 * Spring Beans must follow the standard convention of having a no-args constructor.
	 * In addition, if there are instance variables that we will use setter injection for, we must follow the standard naming convention setVarName().
	 * 
	 * 
	 * 
	 */
	
	
	private String message;
	
	public HelloSpring() {}
	
	

	public HelloSpring(String message) {
		super();
		this.message = message;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	

}
