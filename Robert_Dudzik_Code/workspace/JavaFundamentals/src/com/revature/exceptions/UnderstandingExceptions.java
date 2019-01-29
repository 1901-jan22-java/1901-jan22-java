package com.revature.exceptions;

public class UnderstandingExceptions 
{
	/*
	 * Exceptions in Java are objects that are thrown up the stack
	 * at runtime halting the execution of your application when 
	 * something goes wrong. They are typically recoverable if handled properly
	 * 
	 * An exception can be "handled" by either catching it at the moment
	 * its thrown or by having the method that it is thrown it further throw 
	 * it up the stack or "propagate" it. Also known as ducking
	 * */
	public static void main(String[] args) {
		try {
			doSomethingRisky();
		}
		catch(RuntimeException e)
		{
			System.out.println("Something went wrong + " + e.getMessage());
		}
		System.out.println("Made it to the end");
	}
	static void doSomethingRisky() throws RuntimeException
	{
		int[] arr = new int[5];
		
		arr[10] = 5;
	}
	
	static void 
}
