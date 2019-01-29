package com.revature.designpatterns;

public class Driver {
	
	public static void main(String[] args) {
		useSingleton();
	}
	
	static void useSingleton() {
		Singleton a = Singleton.getInstance();
		a.setName("Singleton A");
		System.out.println("A's name is :" + a.getName());
		
		Singleton b = Singleton.getInstance();
		a.setName("Singleton B");
		System.out.println("A's name is :" + a.getName());
		System.out.println("B's name is:" + b.getName()); // these last two lines will show same name - referencing same instance

		
	}

}
