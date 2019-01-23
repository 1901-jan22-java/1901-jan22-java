package com.revature.codingchallenges;

public class IntToHex {
	public static String convert(int num)
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
			default:results = Integer.toString(x) + results; break;
			}
			num /= 16;
		}
		return results;
	}
	public static void main(String[] args)
	{
		String result = convert(32);
		System.out.println(result);
	}
}
