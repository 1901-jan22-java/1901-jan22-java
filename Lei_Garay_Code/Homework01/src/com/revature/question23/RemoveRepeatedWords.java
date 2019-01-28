package com.revature.question23;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveRepeatedWords {
	
	static String removeRepeatedCharacters(String s)
	{
		String sb = "";
		Set<Character> nonRepChars = new HashSet<Character>();
		char [] allChars = s.toCharArray();
		
		for (int i = 0; i < allChars.length; i++) {
			nonRepChars.add(allChars[i]);
		}
		
		for(Character c: nonRepChars) {
			sb += c.toString();
		}
	
		System.out.println(sb);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a string to be processed");
		String s = sc.nextLine();
		System.out.println("Eliminating repetitive characters");
		removeRepeatedCharacters(s);
	}
}
