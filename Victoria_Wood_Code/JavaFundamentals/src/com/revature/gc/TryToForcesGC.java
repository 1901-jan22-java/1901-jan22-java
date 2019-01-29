package com.revature.gc;

public class TryToForcesGC {
	
	public static void main(String[] args) {
		Garbage a = new Garbage("a");
		Garbage b = new Garbage("b");
		Garbage c = new Garbage("c");
		a = null;
		System.gc(); //ask JVM to clean up garbage
		c = b;
		b = new Garbage("new instance");
		System.gc();
		System.out.println("End of mehtod");
	}

}
