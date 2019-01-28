package com.revature.question10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question10 {

	/*
	 * Find the minimum of two numbers using ternary operators
	 * */
	public static void main(String[] args)
	{
		System.out.println("Enter two numbers");
		try{
			Scanner input = new Scanner(System.in);
			int num1 = input.nextInt();
			int num2 = input.nextInt();
			input.close();

			System.out.println("" + smallerNum(num1, num2) + " is the minimum");
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
		}
		
	}
	
	public static int smallerNum(int num1, int num2)
	{
		return num1<num2 ? num1 : num2;
	}
}
