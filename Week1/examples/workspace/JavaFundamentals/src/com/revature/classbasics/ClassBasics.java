package com.revature.classbasics;

public class ClassBasics {
	
	//var declarations 
	int ageVariable;
	String name;
	int num2;
	int num;
	static final int MAX_AGE = 100;
	
	//[access mod] *[non-access modifiers] [return type] [name] ([args])
	public static void main(String[] args) {
		System.out.println("hello there");
	}
	
	/*
	 * Access modifiers 
	 * public - entity is accessible everywhere
	 * protected - entity is accessible within 
	 * 	 package AND its subclasses which may be 
	 *   in other packages 
	 * ___ (AKA default or package) - accessible 
	 *   within the package 
	 * private - only accessible within the class
	 *   it is declared in
	 *   
	 *   Non-access modifiers 
	 *   static - member of the class NOT the instance
	 *   final:
	 *   	- final variable - after initializing, cannot
	 *   	be reassigned 
	 *   	- final methods - cannot override. CAN overload
	 *   	- final class - cannot be extended 
	 *   transient, synchronized, etc...
	 */

}
