package com.revature.scanner;

import java.util.Scanner;

public class Intro {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = s.nextLine();
		System.out.println("Enter age:");
		int age = 0;
		if(s.hasNextInt()){
			age = s.nextInt();
		} else {
			System.out.println("Invalid Number");
		}
		System.out.println(name + " is " + age + " years old.");
		s.close();
	}
}
