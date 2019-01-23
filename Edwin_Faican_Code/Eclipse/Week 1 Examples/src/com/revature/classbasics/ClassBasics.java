package com.revature.classbasics;

public class ClassBasics {
	//var declarations 
	int ageVariable;
	String name;
	int num;
	static final int MAX_AGE = 100;
	
	public static void main(String[] args) {
		System.out.println("Hello there!");
	}
	
	
	//Notes: 
	
	//{access-modifier][non-access modifier][return type][name][arguments]
	
	/*Access Modifiers
	 * public - entity is accessible everywhere
	 * protected - entity is accessible within package and its subclasses which may be in other packages.
	 * ___ (AKA default or package) - accessible within the package.  
	 * private - only accessible within class it is declared in. 
	 */
	
	/*Non-Access Modifiers
	 * static - member of the class NOT the instance.
	 * final: 
	 * 	- final variable - after initializing, it cannot be changed. 
	 *  - final methods - cannot override method but can overload them. 
	 *  - final class - cannot be extended. 
	 *  
	 *  transient, synchronize, etc...
	 */
}
