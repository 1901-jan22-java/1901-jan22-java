package com.revature.codingchallenges;

public class Anagram {
	
	public static boolean isAnagram(String s, String t) {
		boolean isAn = false;
		if ( s.length() == t.length()) {
			for(int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == t.charAt(t.length()-i)) {
					isAn = true;
				}else {
					isAn = false;
				}
			}
		}
		
		return isAn;
	}
}


