package com.revature.datatypes;

public class Primitives {
	
	int a; // 4 bytes
	boolean b;
	char c;
	double d; //decimal values 8 bytes
	long e; // whole number values 8 bytes
	float f; //smaller capacity than double. 4 bytes
	short g; // 2 bytes. whole number values
	byte h;
	static int stat;
	
	public static void main(String[] args) {
		//create instance of class
		Primitives prims = new Primitives();
		
		System.out.println(prims.a);
		System.out.println(stat); //print out 0 - all ints default value of 0
	}
		static void autoboxing() {
			/*
			 * Autoboxing is the automatic process of a 
			 * primitive data type converting to its wrapper
			 * class when a reference is changed
			 */
			
			int x = 10;
			Integer wrapper = x;
		}
		
		static void casting() {
			int x = 10;
			long l = x; //casting is done automatically when changing reference to a larger type
			byte b = (byte) x;// must Explicitly cast from a larger type to a smaller type
			// will overflow if too large for smaller type
			
			char letter = 'a';
			int ch = (int) letter; // ASCII value for 'a'
			
		}
		
		static char numToChar(int n) {
			return (char) n;
		}
		
		static void bases() {
			int decimal = 10;
			
			int binary = 0b110101011; // 0b so it is interpreted as binary
			
			//OCTAL (base 8); 0-7
			int octal = 012347; //put 0 as first digit
			
			//HEXADEMICAL (base 16; 0-9; a-f)
			int hex = 0xa13f5; //need 0x before 
		}
		
	}


