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
		str = str.concat(" world!");		//basically just str+="";
		System.out.println(str);
		System.out.println(str.substring(2, 34));
		//substring(int number) returns everything starting from index
		//substring(int num1, int num2) returns everything between index num1 and num2 not inclusive
		
		System.out.println("test");
	}
}