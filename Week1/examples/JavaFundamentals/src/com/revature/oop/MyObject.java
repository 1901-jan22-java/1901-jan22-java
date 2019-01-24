package com.revature.oop;

public class MyObject {
	static int count=0;
	private int id = 5;
	private String name;
	private String description;
	
	

	//MyObject obj = new MyObject();
	/*
	 * A constructor is a special method used in Java 
	 * to CONSTRUCT or instantiate (create a new instance
	 * of) the class it exists in 
	 * 
	 * - if no constructor is declared in a class, a default
	 * constructor exists. it is simply a constructor that 
	 * takes in no arguments and makes a call to the super 
	 * class's constructor
	 * - the first line of a constructor is ALWAYS either 
	 * super(); or this(); 
	 */
	
	//NO ARGS CONSTRUCTOR 
	public MyObject() {
		count++;
		id+=count*5; //auto increment ID by 5 for each instance
	}
	
	//MyObject obj = new MyObject("my name", "my description");
	public MyObject(String name, String description) {
		this();
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	
	
	

}
