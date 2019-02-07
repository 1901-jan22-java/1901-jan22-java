package com.revature.oop;

public class Abstraction {
	/*
	 * OOP pillar - ABSTRACTION 
	 * the process in which certain details of 
	 * implementation are hidden
	 */
	
	public static void main(String[] args) {
		Dog d = new Dog();
		d.survive();
		System.out.println(d.generateKey());
	}
}

interface Livable{
	/*
	 * by default, every method in an interface
	 * is public and abstract
	 * since java 8, we are now able to have 
	 * concrete methods (methods with implementation)
	 * in interfaces, but they MUST be denoted with 
	 * the default keyword
	 */
	default long generateKey() {
		return 10000000L;
	}
	int reproduce();
	void consume();
}

abstract class Animal implements Livable{
	void survive() {
		System.out.println("only the strong remain");
	}
	abstract String speak();
}

abstract class Plant implements Livable{
	
}

class Dog extends Animal{

	@Override
	public int reproduce() {
		return 0;
	}

	@Override
	public void consume() {
	}

	@Override
	String speak() {
		return null;
	}
	
}

@FunctionalInterface
interface myFunctionalInterface{
	/*
	 * Functional interfaces are simply interfaces
	 * with ONE and only one abstract method 
	 * (can have 0 or many default methods)
	 */
	void test();
	default void doSomething() {
		System.out.println("test");
	}
}

interface myMarkerInterface{
	
}
