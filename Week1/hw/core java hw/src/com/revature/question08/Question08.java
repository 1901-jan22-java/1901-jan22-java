package com.revature.question08;

import java.util.List;
import java.util.ArrayList;

/*
 * Write a program that stores the following strings in an ArrayList
 * and saves all the palindromes in another ArrayList.
 * "karan" "madam" "tom" "civic" "radar" "sexes" "jimmy" "kayak" "john" "refer" "billy" "did"
 * */
public class Question08 
{
	public static void main(String[] args)
	{
		//made an array list that stored all the strings from the question
		List<String> strings = new ArrayList<String>();
		List<String> palindromes = new ArrayList<String>();
		
		strings.add("karan");
		strings.add("madam");
		strings.add("tom");
		strings.add("civic");
		strings.add("radar");
		strings.add("sexes");
		strings.add("jimmy");
		strings.add("kavak");
		strings.add("john");
		strings.add("refer");
		strings.add("billy");
		strings.add("did");
		
		//runs the check for if the string is palindrome
		//if it is, add to palindrome array list
		for(int i = 0; i < strings.size(); i++)
			if(isPalindrome(strings.get(i)))
				palindromes.add(strings.get(i));

		toString(palindromes);
	}
	
	public static String toString(List<String> myString)
	{
		String result = "";
        
        for(int i = 0; i < myString.size(); i++)
        	result += "" + myString.get(i) + "\n";
    
        return result;
	}
	
	//returns if myString is a palindrome (if the word is spelled the same backwards
	public static boolean isPalindrome(String myString)
	{
		int startIndex = 0;
		int endIndex = myString.length()-1;
		
		//runs a while loop to compare the first/last index
		//keeps going until startIndex passes endIndex
		//basically means it checked half the word
		while(startIndex < endIndex)
		{
			//if the character at the indexes are not the same, it's not a palindrome at that point.
			//break the loop and return false
			if(myString.charAt(startIndex) != myString.charAt(endIndex))
				return false;
			
			startIndex++;
			endIndex--;
		}
		
		//if it got through the loop, it's a palindrome
		return true;
	}
}
