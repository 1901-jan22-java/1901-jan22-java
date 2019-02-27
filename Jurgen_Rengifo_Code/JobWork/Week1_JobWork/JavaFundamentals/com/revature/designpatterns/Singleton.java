package com.revature.designpatterns;

public class Singleton {
	/*
	 * Singleton design pattern - used in scenarios
	 * which require one and only one instance of
	 * an object to be created
	 */
	private String name;
	//the class constructs an instance within itself then return
	
	private static Singleton instnce = new Singleton();
	private Singleton() {
		System.out.println("Contructing Singleton object");
		
	}
	public static Singleton getInstance() {
		return Singleton;
	}
	
}
