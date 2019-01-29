package com.revature.classbasics;

public class Constructors {
	public static void main(String[] args)
	{
		A c = new C();
		System.out.println(c.name);
		System.out.println(c.test());
	}
}

class A
{
	String name;
	public A()
	{
		this.name = "A";
		System.out.println("Constructing A");
	}
	
	String test()
	{
		return "In Class A Value: " + name;
	}
}

class B extends A
{
	String name;
	public B()
	{
		this.name = "B";
		System.out.println("Constructing B");
	}
	String test()
	{
		return "In Class B Value: " + name;
	}
}

class C extends B
{
	String name;
	public C()
	{
		this.name = "C";
		System.out.println("Constructing C");
	}
	String test()
	{
		return "In Class C Value: " + name;
	}
}