package com.revature.Q2;

public class Fibonacci {
	
	public static int FibonacciNum(int n) {
	    if (n < 1) return 0;
		else if (n <= 2) return 1;
		return FibonacciNum(n - 1) + FibonacciNum(n - 2);
	}

}
