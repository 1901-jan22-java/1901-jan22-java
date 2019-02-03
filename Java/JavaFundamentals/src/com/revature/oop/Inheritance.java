package com.revature.oop;

public class Inheritance {

}

interface AA {
	default String test() {
		return "A";
	}
}

interface BB {
	default String test() {
		return "B";
	}
}

class TestClass implements AA, BB {
	@Override
	public String test() {
		return "TestClass";
	}
}