package com.revature.designpatterns;

public class Singleton 
{

	/*
	 * Design patterns are solutions to common problems in coding
	 * Singleton design patterns - used in scenarios which require
	 * one and only one instance of an object to be created
	 * 
	 * This typically means that the class will have a private constructor 
	 * and public getInstance() method that references the singe instance created
	 */
	
	private String name;
	
	//The class constructs an instance within itself to then return
	private static Singleton singleton = new Singleton();
	
	private Singleton()
	{
		System.out.println("Constructing Singleton Object");
	}
	
	public static Singleton getInstance() { return singleton; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void test()
	{
		System.out.println("Eager singleton class loaded");
	}
	
}
