package com.revature.exceptions;

public class UnderstandingExceptions {
	
	/* 
	 * Exceptions in Java are objects that are thrown up the stack at runtime which halts the execution of 
	 * an application when something goes wrong. They are typically recoverable. 
	 * 
	 * An exception can be 'handled' by either catching it at the moment it is thrown or by having the method that 
	 * threw it further throw it up the stack or 'propagate' it. 
	 */
	
	public static void main(String[] args) {
		try {
			doSomethingRisky();
		} catch(RuntimeException e) {
			System.out.println("Something is wrong: " + e.getMessage());
		}
		
		try {
			throwCustom();
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	static void doSomethingRisky() {
		int[] arr = new int[5];
		arr[10] = 5;
	}
	
	static void throwCustom() throws CustomException {
		throw new CustomException();
	}
}
