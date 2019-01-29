package com.revature.gc;

public class Garbage {
	String name;
	
	public Garbage(String name) {
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		/*
		 * this method of the OBject class gets called by the 
		 * garbage collector right before the object itself
		 * not the reference gets is memory deallocated to
		 * free up space
		 * this happens where there are no more references to the object.
		 * 
		 * This method should never directly be called
		 */
		super.finalize();
		System.out.println("GC has desrotyed instance");
	}
	
	
}
