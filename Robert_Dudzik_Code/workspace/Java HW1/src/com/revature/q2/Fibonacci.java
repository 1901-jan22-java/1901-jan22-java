package com.revature.q2;

public class Fibonacci 
{

	public static void main(String[] args)
	{
		int maxNum = 25;
		int previousNum = 0;
		int nextNum = 1;
		
		for(int i = 1; i <= maxNum; i++)
		{
			System.out.println(previousNum + ", ");
			int sum = previousNum + nextNum;
			previousNum = nextNum;
			nextNum = sum;
		}
	}
	
	
}
