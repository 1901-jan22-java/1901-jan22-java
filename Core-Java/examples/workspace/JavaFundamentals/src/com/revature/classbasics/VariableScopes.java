package com.revature.classbasics;

public class VariableScopes {
	/*
	 * the scope of a variable is simply 
	 * where the variable is accessible 
	 * within a class
	 * 
	 * instance/object - accessible to all INSTANCE METHODS
	 *  cannot access instance scoped entities from non 
	 *  instance scoped entities without an instance
	 * static/class - accessible everywhere within a class. 
	 * 	also able to be accessed from the class name itself 
	 *  without an instance from other classes
	 * method scope - declared within method OR passed in 
	 * 	as parameter to method
	 * block - within curly braces(loops, if statements, 
	 * 	static blocks, etc)
	 */
	
	int instanceScope;
	static int staticScope;
	
	public static void main(String[] args) {
		int methodScope = 10;
		
		if (methodScope>staticScope) {
			int blockScope = 5;
		}
		
		//not accessible outside of block it was declared in
		//System.out.println(blockScope);
	}

}
