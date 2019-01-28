package com.revature.Q3;

public class reverseString {

	public static String reverse(String str)
	{
		return reverse(str, str.length() - 1).substring(str.length());
	}
	
	private static String reverse(String str, int index) {
		if (index < 0)
			return str;
		str += str.charAt(index);
		return reverse(str, index - 1);			
	}
}
