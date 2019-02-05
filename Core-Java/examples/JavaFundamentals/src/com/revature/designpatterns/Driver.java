package com.revature.designpatterns;

public class Driver {

	public static void main(String[] args)
	{
		useSingleton();
	}
	
	static void useSingleton()
	{
		Singleton a = Singleton.getInstance();
		a.setName("Singleton A");
		System.out.println("A's name is " + a.getName());

		Singleton b = Singleton.getInstance();
		b.setName("Singleton B");
		System.out.println("B's name is " + b.getName());
		System.out.println("A's name is " + a.getName());

	}
}
