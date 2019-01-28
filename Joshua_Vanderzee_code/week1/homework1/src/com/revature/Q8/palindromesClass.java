package com.revature.Q8;

public class palindromesClass {
	public static boolean IfPalindrome(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1))
				return false;
		}
		return true;
	}
}
