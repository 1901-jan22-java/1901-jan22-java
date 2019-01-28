package com.revature.q6;

public class Modulus 
{

	public static void main(String[] args)
	{
		System.out.println(CheckEven(-13));
	}
	public static boolean CheckEven(int num)
	{
		if(num > 0)
		{
			while(num > 0)
			{
				num -= 2;
			}
			if(num == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			while(num < 0)
			{
				num += 2;
			}
			if(num == 0)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
	}
}
