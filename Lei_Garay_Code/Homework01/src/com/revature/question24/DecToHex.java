package com.revature.question24;

public class DecToHex {

	static String decToHex(int x)
	{
		int remainder = x%16;
		int quotient = x/16;
		
		System.out.println(remainder);
		System.out.println(quotient);
		
		return null;
	}
	
	public static void main(String[] args) {
		decToHex(123456);
	}
}