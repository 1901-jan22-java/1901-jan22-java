package com.revature.question09;

import java.util.ArrayList;
import java.util.List;

/*
 * create an arraylist which stores numbers from 1 to 100 
 * and prints out all the prime numbers to the console
 * */

public class Question09 
{
	public static void main(String[] args)
	{
		//array list to store numbers from 1-100
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++)
		{
			//store numbers to array list
			numbers.add(i);
			//checks to see if number was prime
			if(isPrime(i))
				//print out if number is prime
				System.out.print(i + " ");
		}
		
		
	}
	
	//returns true if number is prime
	public static boolean isPrime(int x)
	{
		//1 is not a prime number
		if(x == 1)
			return false;
		else
		{
			//runs a loop to try and divide X by every possible int up to half the length
			//not the entire length because it's unnecessary
			for(int i = 2; i < x/2; i++)
				//if the number can be divided, it's not a prime
				if(x%i == 0)
					return false;

			//if it makes it to the end of the loop, it wasnt divisible
			return true;
		}
	}
}
