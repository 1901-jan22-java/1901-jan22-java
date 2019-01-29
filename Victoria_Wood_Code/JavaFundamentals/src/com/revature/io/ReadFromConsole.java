package com.revature.io;

import java.util.Scanner;

public class ReadFromConsole {
	
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to my game. What is your name?");
		
		Scanner scan = new Scanner(System.in);
		String name  = scan.nextLine();
		
		System.out.println("Welcome," + name + " What is your age?");
		int age = scan.nextInt(); // will produce exception if no int is written
		
		System.out.println("wow! you are " + age + " years old");
	}

}
