package com.revature.q24;

public class IntToHex 
{

	public static void main(String[] args)
	{
		System.out.println(Convert(166));
	}
	
	public static String Convert(int num)
	{
		String results = "";
		
		while(num > 0)
		{
			int x = num % 16;
			switch(x)
			{
			case 10: results = 'a' + results; break;
			case 11: results = 'b' + results; break;
			case 12:results = 'c' + results; break;
			case 13:results = 'd' + results; break;
			case 14:results = 'e' + results; break;
			case 15:results = 'f' + results; break;
			default:results = x + results; break;
			}
			num /= 16;
		}
		return results;
	}
}
