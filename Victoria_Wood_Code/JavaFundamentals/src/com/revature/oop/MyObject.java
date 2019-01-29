package com.revature.oop;

public class MyObject {
	
	static int count = 0;
	private int id = 5;
	private String name;
	private String description;
	
		
	/*
	 * A constructor is a special method used in Java to CONSTRUCT
	 * or instantiate (create a new instance of) the class it exists in
	 * 
	 * if no contructor is devlared in a class, a default constructor exists. 
	 * it is simply a constructor that takes in no arguments and makes a call to the 
	 * super class's instructor
	 * 
	 * the first line of constructor is Always either super(); or this();
	 */
	
	public MyObject() {
		count++;
		id+= count*5; //auto increment id by 5 for each instance
		
	}
	
	
	// overloaded constructor
	public MyObject(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}



	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
