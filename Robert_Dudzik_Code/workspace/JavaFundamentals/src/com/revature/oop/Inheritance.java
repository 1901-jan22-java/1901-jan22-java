package com.revature.oop;

public class Inheritance 
{
	
}

interface A
{
	default String test()
	{
		return "A";
	}
	
}

interface B
{
	default String test()
	{
		return "B";
	}
}

class TestClass implements A, B
{

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "Overriden method";
	}
}

@FunctionalInterface
interface myFunctionalInterface
{
	//Functional interfaces are simply references with One and only one abstract method
	//Can have 0 or may default methods
	void test();
}

interface myMarkerInterface
{
	
}