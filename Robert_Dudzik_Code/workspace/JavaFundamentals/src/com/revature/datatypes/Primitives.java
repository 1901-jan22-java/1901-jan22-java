package com.revature.datatypes;

public class Primitives {
	int a;// 4 bytes
	boolean b;// true or false
	char c; // '' single character values
	double d;// decimal values 8 bytes
	long e;//whole number values 8 bytes
	float f;// smaller capacity than double, 4 bytes
	short g;// 2 bytes. whole number values
	byte h;
	
	public static void main(String[] args) {
		//create instance of class
		Primitives prims = new Primitives();
		System.out.println("Default values of Primitives: ");
		System.out.println("Int: " + prims.a);
		System.out.println("Boolean: " + prims.b);
		System.out.println("Char: " + prims.c);
		System.out.println("Double: " + prims.d);
		System.out.println("Long: " + prims.e);
		System.out.println("Float: " + prims.f);
		System.out.println("Short: " + prims.g);
		System.out.println("Byte: " + prims.h);
	}
	static void autoboxing() {
		/*
		 * Auto-boxing is the automatic process of a primitive data type converting to its wrapper class when a reference is changed
		 */
		int x = 10;
		Integer wrapper = x;
		
		//For longs and float you need to put the literal at the end
		long l = 100000000L;
		float f = 34.21F;
	}
	
	static void casting()
	{
		int x = 10;
		long l = x;//Automatically is done automatically cast when up casting
		byte b = (byte)x;//Need to cast it manually is down casted
	}

	static void bases()
	{
		int decimal = 10;
		
		//For binary but 0b infront to turn it to binary format
		int binary = 0b11010101;
		
		//Octal base 8; 0-7
		int octal = 012234567;
		
		//Hexadecimal base 16; 0-9, a-f
		int hexadecimal = 0xa13f53;
	}
	
	
}
