package com.revature.assignment1;

// Reflection Stuff I want to practice. Kinda useless right now
public interface Data {
	
	public default Class<? extends Data> thisClass() {
		return getClass();
	}
	
	public default Integer numberOfFields() {
		return this.getClass().getDeclaredFields().length;
	}
	
}
