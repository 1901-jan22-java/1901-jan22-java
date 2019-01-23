package com.revature.datatypes;

public class Primitives {
	int a; //4 bytes 
	double b; //allow for decimals
	float c; //floating point numbers smaller than double
	boolean d; //true or false
	long e; //whole number values but 8 bytes
	short f; //whole number values but 2 bytes
	char g; //'' single character values
	byte h; 
	
	//Wrapper Classes
	Integer integer = new Integer(0);
	Boolean boo = new Boolean(false);
	
	public static void main(String[] args) {
		System.out.println(numToChar(100));
	}
	
	static void intro() {
		Primitives prims = new Primitives();
		System.out.println("Default values: ");
		System.out.println("int: " + prims.a);
		System.out.println("double: " + prims.b);
		System.out.println("float: " + prims.c);
		System.out.println("boolean: " + prims.d);
		System.out.println("long: " + prims.e);
		System.out.println("short: " + prims.f);
		System.out.println("char: " + prims.g);
		System.out.println("byte: " + prims.h);
		
		System.out.println("Integer max value: " + Integer.MAX_VALUE);
		
		String num = "10";
		System.out.println("Value of string: " + Integer.parseInt(num));
		
		//Underscores can be used in numbers in java
		int x = 1_000_000;
		double y = 1_000.1;
		
		long l = 100000000000l; //Must include an 'l' to make the literal into a long. 
		float f = 34.21f; //Must include an 'f' to amke the literal into a float.
	}
	
	static void autoBoxing() {
		/*Autoboxing is the automatic process of 
		 * a primitive data type converting to its wrapper class
		 * when a reference is changed. 
		 */
		
		int x = 10;
		Integer wrapper = x;
	}
	
	static void casting() {
		int x = 1300;
		//Casting is done automatically when changing reference to another type. 
		//Must be from a larger to a smaller type. Cannot cast a large value into a smaller type. 
		long l = x; 
		byte b = (byte) x;
		System.out.println(b);
		
		//long <- int <- short <- byte 
		
		char letter = 'a';
		int ch = (int) letter;
		
		System.out.println("ASCII value for '" + letter + "': " + ch);
	}
	
	static char numToChar(int num) {
		return (char) num;
	}
	
	static void bases() {
		int decimal = 10;
		int binary = 0b0000111; //Use of '0b' in order to work with binary numbers. 
		int octal = 01234567; //Use of '0' in order to work with octal numbers. 
		int hexadecimal = 0xa13f5; //Use of '0x' in order to work with hexadecimal numbers.
	}
}
