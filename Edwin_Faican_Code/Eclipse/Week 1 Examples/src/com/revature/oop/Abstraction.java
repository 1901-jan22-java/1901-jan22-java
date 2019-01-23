package com.revature.oop;

public class Abstraction {
	/*
	 * The process in which certain details of implementation are hidden.
	 */
	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d.generateKey());
	}
	
}

interface Livable {
	default long generateKey() {
		return 298348979l;
	}
	int reproduce();
	void consume();
	
	
	
}

abstract class Animal implements Livable{
	abstract String speak();
	
	void survive() {
		System.out.println("Only the strong remain.");
	}
}

abstract class Plant implements Livable{
	
}

class Dog extends Animal {

	@Override
	public long generateKey() {
		// TODO Auto-generated method stub
		return 0;
	}

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