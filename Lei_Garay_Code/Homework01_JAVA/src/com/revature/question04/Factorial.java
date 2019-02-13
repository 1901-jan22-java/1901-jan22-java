package com.revature.question04;

public class Factorial {
	
	static void factorial(int num)
	{
		int output = num;
		while( output > 1 ){
			num = num * (output-1);
			output--;
		}
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		factorial(10);
	}
}
