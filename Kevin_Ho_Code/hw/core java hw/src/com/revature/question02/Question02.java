package com.revature.question02;

public class Question02 {
	/*
	 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
	 * */
	
	public static void main(String[] args)
	{
		//holds an array of the numbers
		int[] numbers = new int[25];
		numbers[0] = 0;	//first number of sequence
		numbers[1] = 1;	//second number of sequence
		
		//for every index, add the number n-1 and n-2 and store value at the current index
		for(int i = 2; i < numbers.length; i++)
			numbers[i] = numbers[i-2]+numbers[i-1];
		
		//prints out the first 25 numbers
		for(int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + " ");
		System.out.println();
	}
}
