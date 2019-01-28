package com.revature.q9;

import java.util.ArrayList;

public class PrimeNumbers
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		PrimeNumbers pri = new PrimeNumbers();
		for(int i = 0; i < 100; i++)
		{
			if(pri.CheckPrime(i))
				primes.add(i);
		}
		System.out.println(primes);
	}
	
	public boolean CheckPrime(int num)
	{
		for(int i = 2; i <= num / 2; i++)
		{
			int remainder = num % i;
			if(remainder == 0)
				return false;
		}
		return true;
	}
}
