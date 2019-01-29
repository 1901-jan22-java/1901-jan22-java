package com.revature.oop;

public class Abstraction 
{
	/*
	 * OOP pillar - Abstraction
	 * The process in which certain details of implementation are hidden
	 * */
	public static void main(String[] args) 
	{
		
	}
}

interface Livable
{
	//By default every method in an interface is public and abstract, since Java 8, we are now able to have
	//have concrete methods(methods without implementation)
	default long generateKey()
	{
		return 100000L;
	}
	int reproduce();
	void consume();
}

abstract class Animal implements Livable
{
	abstract String speak();
}

abstract class Plant implements Livable
{
	
}

class Dog extends Animal
{

	@Override
	public int reproduce() {
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