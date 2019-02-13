package com.revature.question06;

public class IsEven {
	
	static boolean isEven(int num)
	{
		double numFloor = Math.floor( (double) num / 2);
		
		if ( ( (double) num / 2 - numFloor == 0))
		{
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		return false;
	}
	
	public static void main(String[] args) {
		isEven(2);
		isEven(191);
	}
}
