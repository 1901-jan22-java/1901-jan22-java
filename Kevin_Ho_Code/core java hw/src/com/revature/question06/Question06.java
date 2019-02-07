package com.revature.question06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question06 {

	public static void main(String[] args)
	{
		while(true)
		{
			//checks if user actually enters an int
			try
			{
				System.out.println("Enter a number");
				Scanner input = new Scanner(System.in);
				//prints out the result
				System.out.println(isEven(input.nextInt()));
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
	
	public static boolean isEven(int num)
	{
		//subtract 2 from num until it's 0 or negative
		while(num > 0)
			num -= 2;
		
		System.out.println(num);
		//if number is 0, it's even. otherwise it's -1 which is not even
		return (num==0);
		
	}
}
