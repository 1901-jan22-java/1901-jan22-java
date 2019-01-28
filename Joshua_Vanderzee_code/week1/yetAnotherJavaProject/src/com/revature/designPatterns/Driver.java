package com.revature.designPatterns;

public class Driver {

	public static void main(String[] args) {
		Singleton a = Singleton.getInstance();
		System.out.println(a.getName());
		
		Singleton b = Singleton.getInstance();
		System.out.println(b.getName());
		System.out.println(a.getName());
		
		
		
	}

}
