package com.revature.junit;

import java.util.ArrayList;

public class MethodsToTest {
	
	public boolean anagram(String s, String t) {
		if(s.length()!= t.length()) return false;
		ArrayList<Character> aChars = new ArrayList<Character>();
		for(int i = 0; i < s.length(); i++) {
			aChars.add(s.charAt(i));
		}
		
		for(int i = 0; i < t.length(); i++) {
			int index = aChars.indexOf(t.charAt(i));
			if( index < 0) {
				return false;
			} else {
				aChars.remove(index);
			}
		}
		
		if(aChars.size()==0)return true;
		return false;
	}

}
