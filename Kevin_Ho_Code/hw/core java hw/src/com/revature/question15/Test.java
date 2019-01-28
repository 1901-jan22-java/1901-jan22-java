package com.revature.question15;

public class Test{

	public static void main(String[] args)
	{
		double x = 6;
		double y = 9;
		
		Question15 myTest = new Question15();
		
		System.out.println("x + y = " + myTest.addition(x, y));
		System.out.println("x - y = " + myTest.subtraction(x, y));
		System.out.println("x * y = " + myTest.multiplication(x, y));
		System.out.println("x / y = " + myTest.division(x, y));

	}
}
