package com.revature.q5;

public class SubStringOver
{

	public static void main(String[] args) 
	{
		System.out.println(SubStringBetween("This is a string", 6));
	}
	
	public static String SubStringBetween(String str, int index)
	{
		String np = "";
		int len = index;
		for(int i = 0; i < len; i++)
		{
			np += str.charAt(i);
		}
		return np;
	}
}
