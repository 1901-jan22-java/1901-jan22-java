package com.question3;

public class ReverseString {

	public static void main(String[] args) {
		String myStr = "XOTOURLIF3"; 
		System.out.println(reverseString(myStr));

	}
	//Use Recursion instead of a temp variable.
	public static String reverseString(String myStr){
		if (myStr.isEmpty()){ //Base Case - String method checks whether a String is empty or not. Returns true if string is empty. 
		 return myStr; 
		}
		return reverseString(myStr.substring(1)) // reverseString calls itself and removes the char in index 0.
				+ myStr.charAt(0); // since reverseString is calling itself this line is not run yet, it is waiting on the stack until the base case is met.
		// Once the base case is satisfied, the method calls will complete moving down the stack and adding the char at index 0. 
		//Essentially reversing the original order of the value of each original call.
		
	}

}
