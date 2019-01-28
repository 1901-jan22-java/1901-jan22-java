package com.revature.classbasics;

public class Blocks 
{
	//A block of code is simply a body of statements between opening and closing curly braces
	static
	{
		System.out.println("Static block befoe main method");
	}
	private int id = 5;
	{
		id += 5;
	}
	public static void main(String[] args)
	{
		Blocks block = new Blocks();
		Blocks block2 = new Blocks();
		Blocks block3 = new Blocks();
		System.out.println(block3.id);
	}
	
	public static void test()
	{
		System.out.println("Static method");
	}
}
