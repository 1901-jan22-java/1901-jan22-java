package com.revature.question08;

import java.util.ArrayList;
import java.util.Arrays;

public class SavePalindromes {
	static ArrayList < ArrayList <String> > savePalindromes(ArrayList<String>wordList){
		ArrayList< ArrayList<String> > output = new ArrayList< ArrayList<String>>();
		output.add(wordList);
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for (int i = 0; i < wordList.size(); i++) {
			
			String reWord = wordList.get(i).replaceAll("[^A-Za-z0-9]", "");
		
			int toBeReached = (reWord.length()/2);
			
			if(reWord.charAt(0)==reWord.charAt(reWord.length()-1))
			{
				boolean isPalindrome = true;
				for (int j = 1; j < toBeReached; j++) {
					
					if(reWord.charAt(j)==reWord.charAt((reWord.length()-1)-j)) {
						continue;
					}
					else {
						isPalindrome = false;
						break;
					}
				}
				if(isPalindrome==true)
				{
					palindromes.add(wordList.get(i));
				}
				else {
					isPalindrome = true;
				}
			}
			
		}
		output.add(palindromes);
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println
		(Arrays.asList(savePalindromes(new ArrayList<String>(Arrays.asList("riverdale","ufo tofu","sunflowers")))));
		
	}
}
