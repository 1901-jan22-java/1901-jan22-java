package com.revature.codingchallenges;

public class DetectAnagram {
	public static boolean isAnagram(String a, String b) {
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
	
	public static void main(String[] args) {
		System.out.println(isAnagram("tatttagttaaa", "gattatatatat"));
	}
}
