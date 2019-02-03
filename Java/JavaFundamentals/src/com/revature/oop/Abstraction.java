package com.revature.oop;

/*
 * OOP pillar - ABSTRACTION
 * the process in which certain details of implementation are hidden
 */

public class Abstraction {
	
}

interface Alive {
	int reproduce();
	void consume();
	
	default long generateKey() {
		return 0l;
	}
}

interface random {
	
	default long generateKey() {
		return 1l;
	}
}

abstract class Animal implements Alive {
	
	abstract String speak();
	
	String asd() {
		return "asd";
	}
}

abstract class Plant implements Alive{
	
}

class Dog extends Animal {

	@Override
	public int reproduce() {
		return ((int)(Math.random()*8));
	}

	@Override
	public void consume() {
		System.out.println("Nom nom *kibbles*!");
	}

	@Override
	String speak() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

@FunctionalInterface
interface myFunctionalInterface {
	void test();
}

