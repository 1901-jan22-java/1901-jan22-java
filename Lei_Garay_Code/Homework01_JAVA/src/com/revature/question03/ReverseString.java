package com.revature.question03;

public class ReverseString{

	static void reverseString(String string)
	{
		for (int i = string.length()-1; i >= 0; i--) {
			System.out.print(string.charAt(i));
			if(i==0)
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		reverseString("Hello World");;
	}
}