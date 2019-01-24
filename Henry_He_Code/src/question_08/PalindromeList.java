package question_08;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromeList {
	
	static public boolean isPalindrome(String str) {
		int n = str.length();
		for(int i=0; i<n/2; i++) 
			if( str.charAt(i) != str.charAt(n-i-1) ) return false;
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<String> wordlist = new ArrayList<>(
			Arrays.asList(
				"karan", "madam", "tom", "civic", "radar", "sexes",
				"jimmy", "kayak", "john", "refer", "billy", "did"
			)
		);
		ArrayList<String> result = new ArrayList<>();
		for( String str : wordlist )
			if( isPalindrome(str) )
				result.add(str);
		for( String str: result ) System.out.println(str);
	}
}
