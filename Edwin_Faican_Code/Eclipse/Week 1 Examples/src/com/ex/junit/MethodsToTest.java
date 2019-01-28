package com.ex.junit;

public class MethodsToTest {
	
	public boolean anagram(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		String[] aNew = a.split("");
		String[] bNew = b.split("");
		
		for(String s : aNew) {
			for(int i=0; i<bNew.length; i++) {
				if(s.equals(bNew[i])) {
					bNew[i] = "";
				} 
			}
		}
		for(String s : bNew) {
			if(!s.equals("")) {
				return false;
			}
		}
		return true;
	}
}
