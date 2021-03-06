package com.revature.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class UnderstandingExceptions {

	/*
	 * Exceptions in Java are objects that are thrown 
	 * up the stack at runtime halting the execution of 
	 * your application when something goes wrong 
	 * They are typically recoverable if handled properly
	 * 
	 * An exception can be "handled" by either catching 
	 * it at the moment it's thrown or by having the 
	 * method that it is thrown it further throw it up 
	 * the stack or "propagate" it. (also known as ducking)
	 */

	public static void main(String[] args) {
		
		try {
			throwCustom();
		} catch (CustomException e2) {
			System.out.println(e2.getMessage());
		}
		
		try {
			testChecked();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
		} 
		
		
		try { //"try" to execute risky code
			doSomethingRisky();
		}
		catch(RuntimeException e) {
			//catch the exception in the stack to continue program execution
			System.out.println("Hey something went wrong!: " + 
			e.getMessage());
		}
		finally {
			//typically used to close closable resources 
			System.out.println("WILL ALWAYS EXECUTE");
		}
		System.out.println("Made it to end!");
	}

	static void doSomethingRisky() throws RuntimeException{
		int[] arr = new int[5];
		arr[10] = 5;
	}
	
	static void testChecked() throws IOException{
		throw new IOException();
	}
	
	static void throwCustom() throws CustomException{
		throw new CustomException();
	}

}
