package com.revature.designpatterns;

public class Driver {

	public static void main(String[] args) {
		
	}
	
	public static void useSingleton() {
		Singleton a = Singleton.getInstance();
		System.out.println(a.getName());
	}
	
}
