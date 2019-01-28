package com.revature.designPatterns;

public class lazySingleton {
	private static lazySingleton single;
	private String name;
	
	private lazySingleton() {
		System.out.println("contructing Singleton object");
	}
	
	public static lazySingleton getInstance() {
		if (single != null)
			return single;
		single = new lazySingleton();
		return single;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
