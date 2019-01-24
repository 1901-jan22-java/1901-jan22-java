package com.revature.datatypes;

public class UnderstandingStrings {
	/*
	 * Strings in Java represent a series of characters
	 * - immutable 
	 * - "" literal 
	 * - two ways to create
	 * 	-> String hello = "hello"; (created in string pool)
	 *  -> String hello2 = new String("hello"); (created as regular object in heap memory)
	 */

	public static void main(String[] args) {
		String str = "hello";
		str = str.concat(" world!");
		System.out.println(str);
		System.out.println(str.substring(2, 34));
		System.out.println("test");
	}
	
	/*
	 * Strings are often compared with the StringBuilder
	 * and StringBuffer classes - both are mutable 
	 * versions of strings 
	 * They do the same things except StringBuffer is
	 * synchronized or "thread-safe", whereas 
	 * StringBuilder is not
	 * However, StringBuilder is more efficient than
	 * StringBuffer in terms of time so it is used 
	 * more often 
	 * 
	 */
}
