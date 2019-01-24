package com.revature.Q2;

public class Fibonacci {

	public static void main(String[] args) {
		for (int i = 0; i < 25; i++)
			System.out.println(FibonacciNum(i));
	}
	
	private static int FibonacciNum(int n) {
	    if (n < 1) return 0;
		else if (n <= 2) return 1;
		return FibonacciNum(n - 1) + FibonacciNum(n - 2);
	}

}
