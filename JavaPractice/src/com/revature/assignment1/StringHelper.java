package com.revature.assignment1;

import java.sql.Date;
import java.util.HashSet;

/**
 * Question 18
 * Question 21
 * Question 23
 * 
 * @author Sanford
 *
 */

public class StringHelper extends StringBase {

	private static final String[] testCases = {"1", "lowerUPPER","mix123ER","mix123eRxxxxx", "noupper"};
//	private static final HashMap<String, Integer> month = new HashMap<>();
//	
//	static {
//		month.put("Jan", 1);
//		month.put("Feb", 2);
//		month.put("Mar", 3);
//		month.put("Apr", 4);
//		month.put("May", 5);
//		month.put("Jun", 6);
//		month.put("Jul", 7);
//		month.put("Aug", 8);
//		month.put("Sep", 9);
//		month.put("Oct", 10);
//		month.put("Nov", 11);
//		month.put("Dec", 12);
//	}
	
	public StringHelper(String s) {
		super.s = s;
	}
	
	public static void main(String[] args) {
		
		for(String str: testCases) {
			StringHelper sh = new StringHelper(str);
			
			System.out.println("String: " + sh);
			System.out.println("\t- removeRepeats() returns "	+ sh.removeRepeats());
			System.out.println("\t- hasUpper() returns "		+ sh.hasUpper());
			System.out.println("\t- toUpper() returns " 		+ sh.toUpper());
			System.out.println("\t- addTen() returns "			+ sh.addTen());
		}
		
	}
	
	public static Date toDate(String s) {
//		Date d = 
//		String[] parts;
//		if(s.contains("/")) parts = s.split("/");
//		else parts = s.split(" ");
//		d.setMonth(month.get(parts[0]));
		return null;
	}
	
	public String removeRepeats() {
		return removeRepeats(s);
	}
	
	public static String removeRepeats(String str) {
		HashSet<Character> hs = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for(Character c: str.toCharArray()) {
			if(!hs.contains(c)) {
				hs.add(c);
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	@Override
	public boolean hasUpper() {
		for(Character c: s.toCharArray())
			if(c >= 'A' && c <= 'Z')
				return true;
		return false;
	}

	@Override
	public String toUpper() {
		StringBuilder sb = new StringBuilder();
		for(Character c: s.toCharArray()) {
			if(c >= 'a' && c <= 'z')
				c = (char) (c - 'a' + 'A');
			sb.append(c);
		}
		return sb.toString();
	}

	@Override
	public String addTen() {
		try {
			s = ((Integer) (Integer.parseInt(s) + 10)).toString();
		} catch(NumberFormatException e) {
			
		}
		
		return s;
	}
	
	@Override
	public String toString() {
		return this.s;
	}
	
}

abstract class StringBase {
	protected String s;
	public abstract boolean hasUpper();
	public abstract String toUpper();
	public abstract String addTen();
}
