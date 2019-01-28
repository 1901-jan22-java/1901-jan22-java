package com.revature.oop;

public class Abstraction {

}

abstract class Animal implements Livable{
	abstract String Speak();
}
interface Livable{
	default long GenerateKey(){
		return 10000000000000L;
	}
	int Reproduce();
	void Consume();
}

abstract class Plant implements Livable{
	
}
class Dog extends Animal{

	@Override
	String Speak() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Reproduce() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Consume() {
		// TODO Auto-generated method stub
		
	}
	
}
