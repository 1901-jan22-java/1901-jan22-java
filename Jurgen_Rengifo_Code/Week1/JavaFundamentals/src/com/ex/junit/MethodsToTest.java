package com.ex.junit;

import java.util.ArrayList;

public class MethodsToTest {
	
	public boolean anagram(String a, String b) {
		if(a.length()!=b.length()) return false;
		ArrayList<Character> aChars = new ArrayList<Character>();
		for(int i = 0; i < a.length(); i++){
			aChars.add(a.charAt(i));
		}
		for(int i = 0; i < b.length(); i++){
			int index = aChars.indexOf(b.charAt(i));
		}
		return true;
	}
}