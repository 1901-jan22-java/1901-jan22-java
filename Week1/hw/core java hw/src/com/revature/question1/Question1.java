package com.revature.question1;

public class Question1 {
	/*
	 * Perform a bubble sort on the following integer array: 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4
	 * */
	
	public static int[] intArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	
	public static void main(String[] args)
	{
		System.out.println("Original array");	
		
		//PRINTS OUT THE ORIGINAL ARRAY
		for(int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
		System.out.println();
		
		System.out.println("NOW BUBBLE SORTING");
		
		//INDEX TO KEEP TRACK OF THE LARGEST NUMBER
		int index = intArray.length-1;
		//while loops until every number has been checked
		while(index >= 0)
		{
			//checks every number and swaps up to the index, which should be the largest number
			for(int i = 0; i < index; i++)
			{
				//if intArray[i] is larger than intArray[index-1] swap them
				if(intArray[i] > intArray[i+1])
				{
					int temp = intArray[i];
					intArray[i] = intArray[i+1];
					intArray[i+1] = temp;
				}
			}
			index--;
		}
		//prints out sorted array
		for(int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
		System.out.println();
	}
}
