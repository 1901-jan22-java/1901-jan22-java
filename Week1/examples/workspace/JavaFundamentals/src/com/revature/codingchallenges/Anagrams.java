package com.revature.codingchallenges;

public class Anagrams {
	
	/*
	 * write a method to determine whether or not 
	 * two strings are anagrams 
	 * ie "abcd" and "dacb" ARE anagrams wheras 
	 * "cat" and "car" are not
	 */
	
	public static void main(String[] args) {
		System.out.println(anagram("cat  ", "t a c"));
	}
	
	public static boolean anagram(String a, String b) {
		if(a.length()!=b.length()) return false;
		
		int[] charCount = new int[256];
		int unique = 0;
		
		for(int i = 0; i < a.length(); i++) {
			int index = (int) a.charAt(i);
			if(charCount[index]++ == 0) unique++;
		}
		
		for(int i = 0; i < b.length(); i++) {
			int index = (int) b.charAt(i);
			
			if(charCount[index] == 0) return false;
			else {
				if(--charCount[index] == 0) unique--;
			}
			
		}
		
		if(unique==0) return true;
		
		return false;
	}

}
