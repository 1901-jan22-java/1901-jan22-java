/**
 * 
 * @author Sanford
 *	Pillars of OOP
 *	
 *	Abstraction - "hiding of implementation details"
 *		abstract classes, abstract methods and interfaces
 *
 *	Polymorphism - the ability of one entity to have different behaviors
 *
 *	Inheritance - gaining the behaviors of other classes
 *
 *	Encapsulation - restricting access to entities
 *
 */
package com.revature.oop;

public class MyObject {

	// Test driver
	public static void main(String[] args) {
		
	}
	
	// Initialization
	private int id = 5;
	private String name;
	private String description;
	
	static int count = 0;
	
	// Constructors
	public MyObject() {
		count++;			// auto increment ID by 5 for each instance	
		id += count * 5;
	}
	
	public MyObject(String name, String description) {
		this();
		this.name = name;
		this.description = description;
	}
	
	// Accessors and Mutators
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
