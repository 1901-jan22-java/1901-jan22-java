package com.revature.io;

import java.util.Scanner;

public class ReadFromConsole 
{

	public static void main(String[] args)
	{
		System.out.println("Hello, welcome to my game, what is your name?");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println("Welcome, " + name + "Enter your age: ");
		int age = scan.nextInt();
		System.out.println("Wow you're " + age + "years old!");
		if(age == 2) System.out.println("YEs");
	}
}
