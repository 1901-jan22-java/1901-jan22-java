package com.revature.io;

import java.util.Scanner;

public class ReadFromConsole {

	public static void main(String[] args) {
		System.out.println("Hello! Welcome to my game. What is your name?");
		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println("Welcome, " + name + ". Enter your age");
		int age = scan.nextInt();
		System.out.println("wow! youre " + age + "?! dont look a day over 21!");
	}
	
	

}
