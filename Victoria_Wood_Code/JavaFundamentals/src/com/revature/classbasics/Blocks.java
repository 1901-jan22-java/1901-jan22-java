package com.revature.classbasics;

public class Blocks {
	
	static {
		//typically used to initialize variables
		System.out.println("STATIC BLOCK BEFORE MAIN METHOD");
	}
	
	{
		System.out.println("NON STATIC BLCOK BEFORE MAIN METHOD");
	}
	
	//method code block
	public static void main(String[] args) {
		
	}
	
	public static void test() {
		System.out.println("STATIC METHOD");
	}

}
