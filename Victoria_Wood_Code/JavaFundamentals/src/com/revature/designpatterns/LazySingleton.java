package com.revature.designpatterns;

public class LazySingleton {
	
	//ONLY THE DECLARATION - gets instantiated in getInstance()
	private static LazySingleton instance;
	
	private LazySingleton() {
		System.out.println("Instantiating lazy singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	// doesn't get instantiated until getInstance() method is called

}
