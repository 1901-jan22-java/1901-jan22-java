package com.revature.question3;

import java.util.Scanner;

public class Question3 {
	/*
	 * Reverse a string without using a temporary variable. 
	 * do NOT use reverse() in the stringbuffer or stringbuilder api
	 * */
	
	public static void main(String[] args)
	{
		//gets the user input
		System.out.println("Enter a string ");
		Scanner input = new Scanner(System.in);
		String myString = input.nextLine();
		input.close();
		//prints out the user's input in reverse
		for(int i = myString.length()-1; i >= 0; i--)
			System.out.print(myString.charAt(i));
	}
}
