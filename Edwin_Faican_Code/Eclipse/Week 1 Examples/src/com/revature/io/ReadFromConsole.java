package com.revature.io;

import java.util.Scanner;

public class ReadFromConsole {
	
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to my game. What is your name?");
		Scanner console = new Scanner(System.in);
		
		String answer = console.nextLine();
		
		System.out.println("Welcome " + answer + ". Enter your age.");
		
		String age = console.nextLine();
		
		System.out.println("So you are " + age + "? Makes sense looking at you.");
	}
}
