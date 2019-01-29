//Zachary Borodin
package com.revature.hw1.Q3;

import java.util.Scanner;

//Reverse a string without using a temporary variable
//done use reverse() in StringBuffer or the String Builder API
public class Q3 {
	
	public static void main(String[] args) {
		System.out.print("Enter a string: ");
		Scanner scan =new Scanner(System.in);
		String in = scan.nextLine();
		System.out.print("That string in reverse is ");
		char chars[] = in.toCharArray();
		String reverse = "";
		for(int i=chars.length-1; i>=0; i--) {
			reverse += chars[i];
		}
		System.out.println(reverse);
	}

}
