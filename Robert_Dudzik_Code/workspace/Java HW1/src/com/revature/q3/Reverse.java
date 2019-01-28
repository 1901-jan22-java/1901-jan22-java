package com.revature.q3;

public class Reverse 
{

	public static void main(String[] args)
	{
		Reverse rev = new Reverse();
		System.out.println(rev.ReverseString("Reverse this string"));
	}
	
	public String ReverseString(String str)
	{
		int len = str.length();
		for(int i = len - 1; i > -1; i--)
		{
			str += str.charAt(i);
		}
		str = str.substring(len, str.length());
		return str;
	}
}
