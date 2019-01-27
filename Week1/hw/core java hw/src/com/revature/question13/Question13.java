package com.revature.question13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question13 {
	/*
	 * make this triangle using loops
	 * 
	 * 0
	 * 10
	 * 101
	 * 0101
	 * */

	public static void main(String[] args)
	{
		//my inputs. add more numbers for more number variety
		int[] nums = {0, 1};
		//how large the triangle is
		int size = 1;
		System.out.println("Enter how large you want the triangle to be. Default is 1");

		try
		{
			//gets user input for how large triangle is
			Scanner input = new Scanner(System.in);
			size = input.nextInt();
			input.close();
			
			
			printTriangle(size, nums);
		}
		catch(InputMismatchException e)
		{
			System.out.println("The input is invalid. Printing out default triangle");
			printTriangle(1, nums);
		}
				
	}
	
	public static void printTriangle(int size, int[] nums)
	{
		//which number from the number array to pick
		int index = 1;
		
		//counter for how many numbers are in the current line
		int columnSize = 0;
		
		//runs for loop to print out the number of rows
		for(int i = 1; i <= size; i++)
		{
			//increments the column
			columnSize++;
			
			//in the row, add numbers until the column reaches the same index as row
			//ex. 1 column for row 1, 2 columns for row 2, 3 columns for row 3...
			for(int j = 1; j <= columnSize; j++)
			{				
				//breaks when there's more columns than the row
				if(columnSize > i)
					break;
				else
				{
					//picks the number and resets when overflows
					if(index >= nums.length-1)
						index=0;
					else
						index++;
					
					//prints out the column
					System.out.print("" + nums[index] + " ");
				}
			}
			//new line
			System.out.println();
		}
	}
}
