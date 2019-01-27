package com.question4;

public class NFactorial {

	public static void main(String[] args) {
		System.out.println(factorial(34));
	}
	
	public static int factorial(int n){
		if (n == 0){
			return 1;
		} else {
			return n * factorial(n-1);// Recursion - factorial is run with n-1 until the base case is met
			//then each call on the stack will multiply each consecutive number counting up until the original value of n.
			//4 - 3 - 2 - 1 - 0 -> 1 * 1 * 2 * 3 * 4 = 24
		}
	}
}
// Only works until 31, 32 && 33 gives a negative number and anything > 33 gives 0. Number becomes to large.
