package com.revature.pojos;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1303562873077118708L; 
	//auto-generated when you implement serializable
	// suggestion under Person
	private String email;
	private String name;
	
	public Person() {}
	
	public Person(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
