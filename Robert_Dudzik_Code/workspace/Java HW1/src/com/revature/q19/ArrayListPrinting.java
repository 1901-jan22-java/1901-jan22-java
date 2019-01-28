package com.revature.q19;

import java.util.ArrayList;

import com.revature.q9.PrimeNumbers;

public class ArrayListPrinting
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for(int i = 1; i < 11; i++)
			ints.add(i);
		System.out.println(ints);
		int evenNum = 0;
		for(int i = 0; i < ints.size(); i++)
		{
			if(ints.get(i) % 2 == 0)
				evenNum += ints.get(i);
		}
		System.out.println("Sum of Even numbers: " + evenNum);
		int oddNum = 0;
		for(int i = 0; i < ints.size(); i++)
		{
			if(ints.get(i) % 2 == 1)
				oddNum += ints.get(i);
		}
		System.out.println("Sum of Odd numbers: " + oddNum);
		PrimeNumbers prime = new PrimeNumbers();
		for(int i = 0; i < ints.size(); i++)
		{
			if(prime.CheckPrime(ints.get(i)))
			{
				ints.remove(i);
				i--;
			}
		}
		System.out.println(ints);
	}
}
