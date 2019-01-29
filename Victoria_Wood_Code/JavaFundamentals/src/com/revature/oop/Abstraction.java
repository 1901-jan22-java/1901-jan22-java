package com.revature.oop;

public class Abstraction {
	
	/*
	 * OOP pillar - Abstraction
	 * the process in which certain details of implementation are hidden
	 */
	

}

interface Livable {
	default long generateKey() {
		return 1000000L; // classes that implement it then don't have to create their own generateKey() method, just fall back on default
	}
	int reproduce();
	void consume();
	
}

abstract class Animal implements Livable{
	abstract String speak();
}

abstract class Plant implements Livable {
	
}

class Dog extends Animal {

	@Override
	public int reproduce() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void consume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	String speak() {
		// TODO Auto-generated method stub
		return null;
	}
	
}