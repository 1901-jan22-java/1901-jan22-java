package com.revature.q4;

public class Factorial
{

	public static void main(String[] args)
	{
		int num = FactorialInt(8);
		System.out.println(num);
	}
	
	public static int FactorialInt(int num)
	{
		int results = 0;
		if(num == 0)
			return 1;
		results = num * FactorialInt(num - 1);
		return results;
	}
}
