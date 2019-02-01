package com.revature.pojos;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * Generated serialVersionUID -1884460746184266622L
	 */
	private static final long serialVersionUID = -1884460746184266622L;
	
	private String name;
	private String email;
	
	
	public Person() {}
	
	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return name + ";" + email;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
