package com.revature.designPatterns;

public class Singleton {

	private static Singleton single = new Singleton();
	private String name;
	
	private Singleton() {
		System.out.println("contructing Singleton object");
	}
	
	public static Singleton getInstance() {
		return single;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
