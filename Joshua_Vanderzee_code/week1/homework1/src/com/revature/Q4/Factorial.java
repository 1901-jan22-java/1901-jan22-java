package com.revature.Q4;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(computeFactorial(3));
	}
	
	private static int computeFactorial(int num)
	{
		if (num == 1)
			return 1;
		return num * computeFactorial(num - 1);
	}
}
