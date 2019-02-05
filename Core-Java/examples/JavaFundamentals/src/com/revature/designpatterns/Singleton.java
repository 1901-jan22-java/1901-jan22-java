package com.revature.designpatterns;

public class Singleton {
	/*
	 * Singleton design pattern- used in scenarios which require
	 * one and only one instance of an object to be created
	 * 
	 * This typically means that the class will have a private constructor 
	 * and public getInstance() method that references the single instance created
	 * */
	
	private String name;
	
	//the class constructs an instance within itself to then return 
	private static Singleton singleton = new Singleton();
	
	private Singleton(){
		System.out.println("Constructing Singleton Object");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
