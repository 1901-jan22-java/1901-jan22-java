package com.revature.question14;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Question14 {

	/*
	 * do a switch case
	 * case 1 : find square root of a number using math class method
	 * case 2 : display today's date
	 * case 3 : split string and store in string array
	 * */
	
	public static void main (String[] args)
	{
		int myCase = 0;
		System.out.println("Enter a number from 1-3");
		
		try{
			Scanner input = new Scanner(System.in);
			myCase = input.nextInt();
			
			switch(myCase)
			{
				case 1:
					double D = input.nextDouble();
					System.out.println("Enter a number to find the square root of");
					System.out.println(runCase1(D));
					break;
				case 2:
					System.out.println("Printing the date and time");
					System.out.println(runCase2());
					break;
				case 3:
					System.out.println("Splitting a string");
					for(String s : runCase3())
						System.out.println(s);
					break;
				default:
					System.out.println("No case exists");
					break;
			}
			input.close();
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid input");
		}
		finally 
		{
			System.out.println("Exiting code");
		}
	}
	
	public static double runCase1(double D)
	{
		return Math.sqrt(D);
	}
	
	public static Date runCase2()
	{
		Date today = new Date();
		today = Calendar.getInstance().getTime();
		return today;
	}
	
	public static String[] runCase3()
	{
		String myString  = "I am learning Core Java";
		
		return myString.split(" ");
	}
}
