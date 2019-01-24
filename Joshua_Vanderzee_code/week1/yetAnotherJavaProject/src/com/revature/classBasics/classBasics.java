package com.revature.classBasics;

public class classBasics {

	public classBasics() {
		System.out.println("constructure");
	}
	
	static String[] st = new String[] {
		"this",
		"string array",
		"is",
		"working"
	};
	int age;
	String name;
	static final int MAX_AGE = 100;
	
	static void Block() {
		System.out.println("static method");
	}
	
	{
		System.out.println("non static block");
	}
	
	public static void main(String[] args) {
		System.out.println("");
		classBasics.Block();
		classBasics c = new classBasics();
		c.Block();
		int num = 1;
		
		//for each - enhanced for loop
		for (String d : st)
		{
			System.out.println(d);
		}
		

		
		if (num == 1)
		{
			System.out.println("if");
		}
		else
		{
			System.out.println("else");
		}
		
		
		switch (num)
		{
		case 1:
			System.out.println("1");
			break;
		case 50: 
			System.out.println("50");
			break;
		default:
			System.out.println("another number");
			break;
		}
		
		long l = 10000000000l;
		float f = 1515.05115f;
		
		System.out.println(l);
		System.out.println(f);
	}

	
	static void bases() {
		int binary = 0b01010010;
		
		int octal = 012467;
		
		int hex = 0x1516548f;
	}
}
