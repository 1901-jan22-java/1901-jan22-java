package com.revature.classbasics;

public class Blocks {
	
	/*
	 * A block of code is simply a body of 
	 * statements between opening and closing curly braces 
	 */
	
	static {
		//typically used to initialize variables
		System.out.println("STATIC BLOCK BEFORE MAIN METHOD");
	}
	
	{
		System.out.println("NON-STATIC BLOCK BEFORE MAIN METHOD");
	}
	
	//method code blocks 
	public static void main(String[] args) {
		System.out.println("IN MAIN METHOD");
	}
	
	public static void test() {
		System.out.println("STATIC METHOD");
	}

}
