package com.revature.assignment1;

public interface Data {
	
	public default Class<?> thisClass() {
		return getClass();
	}
	
	public default Integer numberOfFields() {
		return this.getClass().getDeclaredFields().length;
	}
	
}
