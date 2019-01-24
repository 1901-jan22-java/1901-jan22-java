package com.revature.codingchallenges;

public class Anagrams {
	/*
	 * write a method to determine whether or not
	 * two strings are anagrams
	 * ex "abcd" and "dacb" are anagrams whereas
	 * "cat" and "car" are not
	 * 
	 * -- assume that only letters will be passed in
	 * and will be the same case
	 * */
	
	public boolean anagram(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		
		int[] charCount = new int[256];
		int unique = 0;
		
		for(int i = 0; i < a.length(); i++)
		{
			int index = (int) a.charAt(i);
			if(charCount[index]++ == 0) unique++;
		}

		for(int i = 0; i < b.length(); i++) {
			int index = (int)
		}
		return false;
	}

}
