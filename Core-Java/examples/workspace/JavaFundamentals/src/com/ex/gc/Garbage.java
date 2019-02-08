package com.ex.gc;

public class Garbage {
	String name;
	
	public Garbage(String name) {
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable {
		/*
		 * this method of the Object class gets called
		 * by the garbage collector right before the 
		 * object itself (not the reference) gets its 
		 * memory deallocated to free up space 
		 * this happens when there are no more references 
		 * to the object. 
		 * This method should never directly be called 
		 * 
		 */
		System.out.println("GC has destroyed instance "+ this.name);
		super.finalize();
	}
}
