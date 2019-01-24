package com.revature.factorial;

public class ComputeFactorial {
	public static int factorial(int a) {
		if( a == 1 || a == 0) {
			return 1;
		} else if(a == 2) {
			return 2;
		}
		
		return factorial(a, a-1);
	}
	
	public static int factorial(int a, int b) {
		if(a == 2) {
			return 2;
		}
		
		return a * factorial(b, b-1);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(4));
	}
}
