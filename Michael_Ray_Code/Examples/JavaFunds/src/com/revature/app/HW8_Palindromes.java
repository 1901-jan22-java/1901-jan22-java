package com.revature.app;

import java.util.ArrayList;
import java.util.List;

public class HW8_Palindromes {
public static void main(String[] args) {
	List<String> words = new ArrayList<String>();
	
	List<String> notPalin = new ArrayList<String>();
	List<String> palin = new ArrayList<String>();
	words.add("karan");
	words.add("madam");
	words.add("tom");
	words.add("civic");
	words.add("radar");
	words.add("sexes");
	words.add("jimmy");
	words.add("kayak");
	words.add("john");
	words.add("refer");
	words.add("billy");
	words.add("did");
	
	for(String s : words){
		
		if(IsAPalindromes(s)){
			palin.add(s);
		}
		else{
			notPalin.add(s);
		}
		
	}
	
	System.out.println(palin);
	System.out.println(notPalin);
	
}

public static boolean IsAPalindromes(String s1){
	boolean isPalin = true;
	
	int length = s1.length();
	
	for(int i = 0; i < length; i++){
		if(s1.charAt(i) != s1.charAt((length - 1) - i)){
			isPalin = false;
			break;
		}
	}
	
	return isPalin;
}
}
