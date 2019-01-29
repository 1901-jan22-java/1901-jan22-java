package com.revature.classbasics;

public class VariableScopes
{
	/*
	 * the scope of a variable is simply where the variable
	 * is accessible within a Class
	 * 
	 * block- within loops, if statements, static blocks, etc
	 * method scope - declared within method or passed in as parameter to method
	 * instance/object - accessible to all instance methods cannot access instance scoped entities from
	 * non instance scoped entities without an instance
	 * static/class - accessible everywhere  within a class also able to accessed from the class name itself
	 *  without an instance from other classes
	 * */
	int instanceScope;
	static int staticScope;
	
	public static void main(String[] args) {
		int methodScope = 10;
		if(methodScope > staticScope)
		{
			int blockscope = 5;
		}
	}
}
