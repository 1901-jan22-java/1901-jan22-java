package com.revature.pojos;

import java.io.Serializable;

public class Person implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1884460746184266622L;
	private String name;
	private String email;
	
	@Override
	public String toString() {
		return name+ ";" +email + ";";
	}

	
	public Person() {}
	
	public Person(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
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
