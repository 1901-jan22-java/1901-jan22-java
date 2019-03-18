package com.revature.autowired;

import org.springframework.stereotype.Component;

/*
 * Spring uses many annotations to register classes as beans. Again these are simply objects that will be managed by the container. 
 * For simple pojos, we use the @component annotation we will later see others, like
 * service
 * 
 * 
 * 
 * 
 */




@Component
public class Department {
	
	private String name;
	
	
	public Department() {}


	public Department(String name) {
		super();
		this.name = name;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	
	

}
