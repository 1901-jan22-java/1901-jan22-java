package com.revature.Q3;

public class reverseString {

	public static void main(String[] args) {
		try {
			System.out.println(reverse(args[0]));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("There is no string to reverse.");
		}
	}

	private static String reverse(String str)
	{
		return reverse(str, str.length() - 1).substring(str.length());
	}
	
	private static String reverse(String str, int index) {
		try 
		{
			str += str.charAt(index);
			return reverse(str, index - 1);
		}
		catch (Exception e)
		{
			return str;
		}
	}
}
