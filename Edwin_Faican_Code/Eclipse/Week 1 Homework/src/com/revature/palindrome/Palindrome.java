package com.revature.palindrome;

import java.util.ArrayList;
import java.util.Stack;

public class Palindrome {
	
	public static boolean isPalindrome(String s) {
		Stack<String> letters = new Stack<String>();
		int half;
		
		//There are two cases. One where the number of letters is even, the other where they are odd. 
		//For the case in which they are even, we set an int to hold the index halfway through the string. 
		//We do the same for the odd case except to make it streamlined, the middle letter is removed since it 
		//Would not be repeated in a palindrome and holds small importance since it only needs to occur once. 
		if(s.length()%2 == 0) {
			half = s.length()/2;
		} else {
			half = s.length()/2;
			s = s.substring(0,half) + s.substring(half+1, s.length());	
		}
		
		//A stack is used to push all letters halfway into the string. 
		for(int i=0; i< half; i++) {
			letters.push(s.substring(i, i+1));
		}
		
		//The stack items are then popped out and compared to the rest of the letters in the string. 
		//If any letters do not match, it is not a palindrome. 
		int count = 0;
		while(!letters.isEmpty()) {
			if(!s.substring(half + count, half+ count+1).equalsIgnoreCase(letters.pop())) {
				return false;
			}
			count++;
			
		}
		return true;
	}
	
	public static ArrayList<String> findPalindromes(ArrayList<String> words) {
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String s : words) {
			if(isPalindrome(s)) {
				palindromes.add(s);
			}
		}
		return palindromes;
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		System.out.println(findPalindromes(words));
	}
}
