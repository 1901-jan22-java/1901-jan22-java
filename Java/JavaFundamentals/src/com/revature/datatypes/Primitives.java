package com.revature.datatypes;

public class Primitives {

	boolean a;
	byte b;
	short c;
	char d;
	int e;
	long f;
	float g;
	double h;
	
	static int stat;
	
	public static void main(String[] args) {
		
		Primitives prims = new Primitives();
		
		
		System.out.println("boolean: "	+	prims.a);
		System.out.println("byte: "		+	prims.b);
		System.out.println("short: "	+	prims.c);
		System.out.println("char: "		+	prims.d);
		System.out.println("int: "		+	prims.e);
		System.out.println("long: "		+	prims.f);
		System.out.println("float: "	+	prims.g);
		System.out.println("double: "	+	prims.h);
		
		System.out.println();
		stat = 10;
		
		casting();
	}
	
	static void autoboxing(Object... objects){
		int x = 1240;
		
		Integer asdf = x;
		
		System.out.println(asdf);
	}
	
	static void casting(){
		int x = 1300;
		long l = x;
		byte b = (byte) x;
		
		System.out.println( "x="+ x + "b=" + b + "l=" + l );
	}
	
}

