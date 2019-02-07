package com.revature.oop;

public class Inheritance {

}


interface A{
	default String test() {
		return "A";
	}
}

interface B{
	default String test() {
		return "B";
	}
}

class TestClass implements A, B{

	@Override
	public String test() {
		return "Overriden method";
		
	}
	
}
