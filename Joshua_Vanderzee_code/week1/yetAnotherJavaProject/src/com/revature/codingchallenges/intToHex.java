package com.revature.codingchallenges;

public class intToHex {
	public static void main(String[] args) {
		
		System.out.println();
		intToHex(1000);
	}
	
	static void intToHex(int num)
	{	
		int hex = 0;
		do {
			hex = num % 16;
			num /= 16;
			System.out.println((char)( hex + 48));
		} while (num > 0);
	}
}
