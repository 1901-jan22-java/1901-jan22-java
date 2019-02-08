package com.revature.designpatterns;

public class LazySingleton {
	
	//ONLY THE DECLARATION. Gets instantiated in getInstance() method
	private static LazySingleton instance;
	
	private LazySingleton() {
		System.out.println("instantiating lazy singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public static void test() {
		System.out.println("Lazy singleton class loaded");
	}

}
