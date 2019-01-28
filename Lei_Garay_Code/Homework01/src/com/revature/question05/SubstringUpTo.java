package com.revature.question05;

public class SubstringUpTo {

	static String subStringUpTo(String string, int stop)
	{
		String subString = "";
		
		if( stop < string.length() )
		{
			for (int i = 0; i < stop+1; i++) {
				subString += string.charAt(i);
			}
		}
		return subString;
	}
	
	public static void main(String[] args) {
		System.out.println(subStringUpTo("Hello World", 4));
	}
}
