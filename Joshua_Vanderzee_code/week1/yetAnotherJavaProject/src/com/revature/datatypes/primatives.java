package com.revature.datatypes;

public class primatives {
	int a;
	boolean b;
	char c;
	double d;
	long e;
	float f;
	short g;
	byte h;
	static int stat;
	
	Integer integer = new Integer(5);
	
	public static void main(String[] args) {
		primatives p = new primatives();
		System.out.println(p.a);
		System.out.println(p.b);
		System.out.println(p.c);
		System.out.println(p.d);
		System.out.println(p.e);
		System.out.println(p.f);
		System.out.println(p.g);
		System.out.println(p.h);
		System.out.println(stat);
		System.out.println(p.integer.MAX_VALUE);
		
		int x = 1_000_000;
		
		autoboxing();
		
		
		System.out.println(numtoChar(100));
	}
	
	static void intro() {
		
	}
	
	static void autoboxing() {
		int x = 1300;
		Integer wrapper = x;
		byte b = (byte)x;
		System.out.println(b);
		
		char c = 'a';
		int ch = c;
		System.out.println(ch);
	}
	
	static char numtoChar(int n) {
		return (char)n;
	}
}
