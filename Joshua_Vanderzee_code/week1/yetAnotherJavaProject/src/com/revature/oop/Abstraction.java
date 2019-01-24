package com.revature.oop;

public class Abstraction {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.survive();
	}

	
}

interface ILivable{
	default long generateKey() {
		return 032032020;
	}
	int reproduce();
	void consume();
}

abstract class Animal implements ILivable{
	abstract String speak();
}

abstract class Plant implements ILivable{
	
}

class Dog extends Animal{

	@Override
	public int reproduce() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void consume() {
		// TODO Auto-generated method stub
		
	}

	public void survive() {
		
	}
	
	@Override
	String speak() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
