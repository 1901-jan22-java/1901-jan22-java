package com.ex.junit;

import java.util.HashMap;

public class MethodsToTest {

	public boolean anagram(String a, String b) {
		if( a.length() != a.length() ) return false;

		HashMap<Character, Integer> ac = charCount(a);
		HashMap<Character, Integer> bc = charCount(b);

		for(Character c: ac.keySet())
			if( !bc.containsKey(c) || !ac.get(c).equals(bc.get(c)) ) return false;
		
		return true;
	}

	private static HashMap<Character, Integer> charCount(String str) {
		HashMap<Character, Integer> count = new HashMap<>();
		for(Character c: str.toCharArray())
			if(!count.containsKey(c)) count.put(c, 1);
			else count.put(c, count.get(c)+1);
		return count;
	}
	
}
