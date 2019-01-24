package com.revature.palindrome;

import java.util.Stack;

public class Palindrome {
	
	public static boolean isPalindrome(String s) {
		Stack<String> letters = new Stack<String>();
		int half;
		
		if(s.length()%2 == 0) {
			half = s.length()/2-1;
		} else {
			half = s.length()/2;
			s = s.substring(0,half) + s.substring(half+1, s.length());
			System.out.println(s);
			half--;
		}
		
		for(int i=0; i<= half; i++) {
			letters.push(s.substring(i, i+1));
			System.out.println(letters);
		}
		
		int count = 0;
		while(!letters.isEmpty()) {
			System.out.println(s.substring(half + count, half+ count+1));
			if(!s.substring(half + count, half+ count+1).equalsIgnoreCase(letters.pop())) {
				return false;
			}
			count++;
		}
		
		
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("Voodoov"));
	}
}
