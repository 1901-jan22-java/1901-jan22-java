package com.revature.Q4;

public class Factorial {
	
	public static int computeFactorial(int num)
	{
		if (num <= 1)
			return 1;
		return num * computeFactorial(num - 1);
	}
}
