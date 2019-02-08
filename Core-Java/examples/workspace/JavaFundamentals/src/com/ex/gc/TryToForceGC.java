package com.ex.gc;

public class TryToForceGC {

	public static void main(String[] args) {
		Garbage a = new Garbage("a");
		Garbage b = new Garbage("b");
		Garbage c = new Garbage("c");
		a = null;
		System.gc(); // ASK the JVM to clean up garbage
		c = b; 
		b = new Garbage("new instance");
		System.gc();
		System.out.println("at end of method");
		
	}
}
