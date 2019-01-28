package com.revature.oop;

public class MyObject {
	//Abstraction - Hiding of implementation details, don't need to know how a class works
	//Such as abstract classes and methods interfaces
	//Inheritance - The ability for objects to take on the behavior of other objects
	//Implemented by using extends keyword, so class A extends B, implements
	//Encapsulation - Restricting data access. Getters & Setters || mutators and accessors
	//Polymorphism - The ability of an object to take on different behavior
	//Method overloading and overiding is an example
	//Overloadng is same name and multiple implementationss of the same method in the same class
	//Overriding is having the same behavior from a parent class and changing how the method works
	static int count = 0;
	private int id = 5;
	private String name;
	private String description;
	
	
	/*
	 * A constructer is a special method used in Java
	 * to construct or instantiate the class it exists in
	 * if not constructor is declared in a class, a default constructer exists. 
	 * it is simply a constructor that takes in no arguments and makes a call to the super 
	 * class's constructor 
	 * the first line of a constructor is always either super(); or this();
	 * */
	
	public MyObject()
	{
		super();
		count++;
		id += count*5;
	}
	
	public MyObject(String name, String description) {
		this();
		this.name = name;
		this.description = description;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
