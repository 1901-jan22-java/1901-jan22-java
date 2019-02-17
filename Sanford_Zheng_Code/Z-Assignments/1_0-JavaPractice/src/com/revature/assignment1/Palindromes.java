package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Question 8
 * 
 * @author Sanford
 *
 */

public class Palindromes {
	
	private static final ArrayList<String> test = new ArrayList<>(
			Arrays.asList("karan", "madam","tom", "civic", "radar", "sexes", 
					"jimmy", "kayak", "john", "refer", "billy", "did"));
	
	public static void main(String[] args) {
		System.out.println(find(test));
	}
	
	public static ArrayList<String> find(ArrayList<String> arr){
		ArrayList<String> palins = new ArrayList<>();
		
		for(String s: arr)
			if(isPalindrome(s))
				palins.add(s);
		
		return palins;
	}
	
	public static boolean isPalindrome(String s) {
		char[] sc = s.toCharArray();
		
		for(int i = 0; i < sc.length/2; i++) 
			if(sc[i] != sc[sc.length-1-i])
				return false;
		
		return true;
	}
	
}

class PalindromesTest {
	
}
