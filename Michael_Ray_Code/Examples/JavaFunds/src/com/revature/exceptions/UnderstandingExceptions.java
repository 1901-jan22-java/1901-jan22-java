package com.revature.exceptions;

public class UnderstandingExceptions {
public static void main(String[] args) {
	DoSomethingRisky();
	System.out.println("Made it to end");
}
static void DoSomethingRisky() throws RuntimeException{
	int[] arr = new int[5];
	
	arr[10] = 5;
}
}
