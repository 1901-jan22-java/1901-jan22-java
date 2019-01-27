package com.revature.question05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question05 {
	/*
	 * write a substring method that accepts a 
	 * string str and an integer idx and returns
	 * the substring contained between 0 and idx-1 inclusive.
	 * dont use substring methods that already exist
	 * */
	
	public static void main(String[] args) throws InputMismatchException
	{
		while(true)
		{
			try
			{
				//gets user input
				Scanner input = new Scanner(System.in);
				System.out.println("Enter a string");
				String str = input.nextLine();
				System.out.println("Enter an int");
				int idx = input.nextInt();
				input.close();
				
				System.out.println(substring(str, idx));
				break;
			}
			//if user enters invalid inputs, make them try again
			catch(InputMismatchException e)
			{
				System.out.println("Invalid inputs. Try again.");
			}
		}
	}
	
	public static String substring(String str, int idx) throws StringIndexOutOfBoundsException
	{
		try
		{
			String result = "";
		
			//loops from 0 up to given index - 1
			for(int i = 0; i < idx; i++)
				result += str.charAt(i);
		
			return result;
		}
		//if user gives an invalid index, return empty string and say index out of bounds
		catch(StringIndexOutOfBoundsException e)
		{
			System.out.println("Index is out of bounds");
			return "";
		}
	}

}
