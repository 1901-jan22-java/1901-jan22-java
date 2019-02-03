package com.revature.codingchallenges;

import java.util.HashMap;

public class AnagramChallenge {

	public static boolean anagram(String a, String b) {
		HashMap<Character, Integer> list1 = count(a);
		HashMap<Character, Integer> list2 = count(b);
		
		for(Character c: list1.keySet())
			if(!list2.containsKey(c) || list1.get(c) != (list2.get(c))) return false;
		
		return true;
	}
	
	public static HashMap<Character, Integer> count(String str) {
		HashMap<Character, Integer> count = new HashMap<>();
		for(char c: str.toCharArray())
			if(!count.containsKey(c)) count.put(c, 1);
			else count.put(c, count.get(c) + 1);
//		System.out.println(count);
		return count;
	}
}
