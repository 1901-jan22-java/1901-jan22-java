package com.question8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		ArrayList<String> palArray = new ArrayList<String>(); // Create arraylist for palindromes to be added to
		ArrayList<String> array = new ArrayList<String>(); // Create arraylist to be interated over to check for palindromes
		array.add("karan");
		array.add("madam");
		array.add("tom");
		array.add("civic");
		array.add("radar");
		array.add("sexes");
		array.add("jimmy");
		array.add("kayak");
		array.add("john");
		array.add("refer");
		array.add("billy");
		array.add("did");
		
		for(int i = 0; i < array.size(); i++){
			if(isPalindrome(array.get(i)) == true){ // gets each element of the array and passes it through the isPalindrome method
				palArray.add(array.get(i)); // If the method returns true, add the string to the palArray
			}
		}
		System.out.println(array.toString());
		System.out.println(palArray.toString());
	}
	
	public static boolean isPalindrome(String str) { // Return true if the original str is equal to the new string built to be reversed and returned again as a string.
	    return str.equals(new StringBuilder(str).reverse().toString()); // .reverse will seperate each letter in the str to a seperate char, reverse them, and then join them back into a string with .toString
	}

}
