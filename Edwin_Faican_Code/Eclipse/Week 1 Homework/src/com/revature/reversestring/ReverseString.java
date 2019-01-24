package com.revature.reversestring;

public class ReverseString {
	public static String reverse(String s) {
		for(int i=0; i < s.length(); i++) {
				s = s.substring(1,s.length() - i) + s.charAt(0) + s.substring(s.length() - i);
				System.out.println(s);
		}
		return s;
	}
	
	public static void main(String[] args) {
		reverse("hello");
	}
}
