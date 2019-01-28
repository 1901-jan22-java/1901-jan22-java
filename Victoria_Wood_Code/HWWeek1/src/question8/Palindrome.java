package question8;

import java.util.ArrayList;

public class Palindrome {
	
	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("karan"); words.add("madam"); words.add("tom");words.add("civic");
		words.add("sexes"); words.add("jimmy"); words.add("john"); words.add("refer");
		words.add("billy"); words.add("did");
		
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for (String s: words) { //checks if each word in arraylist words is palindromes
			if (isPalindrome(s)) {
				palindromes.add(s);//adds into palindrome list if isPalindrome(s) returns true
			}
		}
		
		System.out.println(words);
		System.out.println(palindromes);
		
		
	}
	
	public static boolean isPalindrome(String s) {
		if (s.length()%2 == 0) return false; //checks if length of string is even - all palindromes have odd lengths
		
		for(int i = 0; i < s.length(); i++) { //for each loop checks if characters at each end of string are the same moving towards center
			if (s.charAt(i) != s.charAt(s.length()-(i+1))) return false;
		}
		return true;
		
	}
	
	

}
