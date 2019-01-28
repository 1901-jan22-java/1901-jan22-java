package com.revature.classbasics;

public class Blocks {

	static{
		// Typically used to initialize variables
		System.out.println("Static block Before Main Method");
	}
	{
		System.out.println("Non - Static block Before Main Method");
		
	}
	public static void main(String[] args) {
		System.out.println("In Main Method");
	}
	public static void Test(){
		System.out.println("Static Metho");
	}
}
