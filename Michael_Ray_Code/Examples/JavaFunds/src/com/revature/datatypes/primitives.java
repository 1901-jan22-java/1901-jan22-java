package com.revature.datatypes;

public class primitives {
	
	int a; // 4bytes
	boolean b; // 1bytes (shame because they only end up using one bit in the end)
	char c; //1byte
	double d; //8bytes
	long e; // 8bytes
	float f; // 4bytes
	short g; // 2bytes
	byte h; // 1byte
	
	public static void main(String[] args) {
		primitives prims = new primitives();
		
		System.out.println(prims.a);
	}
	static void autoBoxing()
	{
		
		
	}
}
