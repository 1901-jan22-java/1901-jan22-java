package com.revature.question10;

public class FindLesser {
	static int min(int a,int b)
	{
		return a > b ? b : a;
	}
	
	public static void main(String[] args) {
		System.out.println(min(50,50));
	}
}
