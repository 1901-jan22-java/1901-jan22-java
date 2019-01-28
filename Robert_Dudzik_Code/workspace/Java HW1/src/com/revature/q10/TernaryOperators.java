package com.revature.q10;

public class TernaryOperators
{

	public static void main(String[] args)
	{
		TernaryOperators ter = new TernaryOperators();
		System.out.println(ter.MinOfInts(10, 14));
	}
	
	public int MinOfInts(int a, int b)
	{
		return (a > b) ? b : a;
	}
}
