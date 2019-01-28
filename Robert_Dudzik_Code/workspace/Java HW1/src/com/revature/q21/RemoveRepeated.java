package com.revature.q21;

public class RemoveRepeated
{

	public static void main(String[] args)
	{
		System.out.println(RemoveRepeatingChars("aaabbccddefggpp"));
	}
	
	public static String RemoveRepeatingChars(String arr)
	{
		String results = "";
		results += arr.charAt(0);
		int len1 = arr.length();
		for(int i = 1; i < len1; i++)
		{
			boolean found = false;
			int len2 = results.length();
			for(int j = 0; j < len2; j++)
			{
				if(arr.charAt(i) == results.charAt(j))
				{
					found = true;
					break;
				}
			}
			if(!found)
				results += arr.charAt(i);
		}
		return results;
	}
	
}
