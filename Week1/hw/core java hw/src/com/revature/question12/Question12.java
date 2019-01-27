package com.revature.question12;

public class Question12 {

	/*
	 * Write a program to store numbers from 1 to 100 in an array. 
	 * Print out all the even numbers from the array. 
	 * Use the enhanced FOR loop for printing out the numbers.
	 * */
	
	public static void main(String[] args)
	{
		//an int array
		int[] myNumbers = new int[100];
		
		//stores 1-100 in the int array
		for(int i = 0; i < 100; i++)
			myNumbers[i] = i;
		
		//foreach loop that checks every index of myNumbers
		for(int i : myNumbers)
			//if it's even, print out the number
			if(myNumbers[i]%2 == 0)
				System.out.print(myNumbers[i] + " ");
	}
}
