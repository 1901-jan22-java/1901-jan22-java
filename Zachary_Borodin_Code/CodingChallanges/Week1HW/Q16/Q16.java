package com.revature.hw1.Q16;

import java.util.Scanner;

//display the number of characters in a string input form the command line
public class Q16 {
public static void main(String[] args) {
	System.out.println("Enter a string and I will tell you how many characters it has");
	Scanner scan = new Scanner(System.in);
	String s = scan.next();
	char c[] = s.toCharArray();
	System.out.println("The string has "+ c.length + " characters.");
}
}
