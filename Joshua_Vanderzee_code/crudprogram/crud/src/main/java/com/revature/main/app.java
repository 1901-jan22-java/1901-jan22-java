package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class app {

	private static Scanner c = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Hello Associate");
		switch (choice("login", "Sign", "cancel")) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		}
	}

	
	private static String getUserInput() {
		while (true) {
			try {
				return c.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid type");
			}
		}
	}
	
	private static long getUserInputLong(boolean required) {
		while (true) {
			try {
				String temp = c.nextLine();
				if (required) {
					if (!temp.equals(""))
						return Long.parseLong(temp);
					System.out.println("This feild is required.");
					continue;
				}
				return 0;
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}
	
	private static int choice(String... str) {
		while (true) {
			int count = 0;
			try {
				for (String string : str) {
					System.out.print(" " + string);
				}
				return Integer.parseInt(c.nextLine());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please use a number");
			}
		}
	}
	
	private static String choice(int StartingNumber, String... str) {
		while (true) {
			int count = StartingNumber;
			try {
				for (String string : str) {
					System.out.print( " " + string);
				}
				int index = Integer.parseInt(c.nextLine());
				return str[index - StartingNumber];
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please use a number");
			}
		}
	}
}
