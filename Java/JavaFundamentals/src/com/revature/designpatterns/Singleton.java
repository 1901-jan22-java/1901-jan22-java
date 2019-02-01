package com.revature.designpatterns;

public class Singleton {
	
	private final static Singleton instance = new Singleton();
	
	private String name;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public static void test() {
		System.out.println("Singleton class loaded");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
