package com.revature.designpatterns;

public class LazySingleton {
	
	private static LazySingleton instance;
	
	private String name;
	
	private LazySingleton() {
		System.out.println("Instantiating lazy singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) instance = new LazySingleton();
		return instance;
	}

	public static void test() {
		System.out.println("Lazy singleton class loaded");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
