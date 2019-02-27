package com.revature.homework;

import java.util.Scanner;
public class NumOfChar
{
	public static void main(String[] args)
	{
		//intitated value
		String s;
		//scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
 		s = sc.nextLine();
 		//prints number of characters
		System.out.println("Number of characters in the input string is: " + s.length());
	}
}
