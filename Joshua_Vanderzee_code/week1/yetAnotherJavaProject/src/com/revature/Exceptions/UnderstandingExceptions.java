package com.revature.Exceptions;

import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) {

		try {
			doSomething();		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			test();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (NullPointerException e) {
			e.printStackTrace();
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("continues");
	}
	static void doSomething() {
		int[] arr = new int[5];
		arr[10] = 5;
	}
	
	static void test() throws Exception {
		throw new CustomException();
	}
}
