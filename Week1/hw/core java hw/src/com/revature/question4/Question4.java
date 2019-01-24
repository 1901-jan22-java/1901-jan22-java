package com.revature.question4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question4 {
	/*
	 * Write a program to compute N factorial
	 * */
	
	public static void main(String[] args) throws InputMismatchException
	{
		//loops until user enters valid input
		while(true)
		{
			//checks if user actually enters an int
			try
			{
				System.out.println("Enter a number");
				Scanner input = new Scanner(System.in);
				//prints out the result
				System.out.println("The value is " + factorial(input.nextInt()));
				input.close();
				
				//breaks out of while loop
				break;
			}
			//if user does not enter int, print out invalid input
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input. Not an int");
			}
		}
	}
	
	//function to find factorial
	public static int factorial(int N)
	{
		//the end result that is returned.
		int result = N;
		
		//while loop to multiply the N by N-1 number of times. N-1 because N is already done by default for cases like 1
		while(N-1 > 0)
		{
			result *= N-1;
			N--;
		}
		
		return result;
	}
}
