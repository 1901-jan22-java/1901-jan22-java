package com.revature.simple.interest;

import java.util.Scanner;

public class SimpleInterest {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("This is a simple interest calculator.\nEnter priniciple: ");
		int r = 0;
		int p = 0;
		int t = 0;
		boolean correctInput = false;
		
		while(!correctInput) {
			if(console.hasNextInt()) {
				p = console.nextInt();
				correctInput = true;
			} else {
				console.nextLine();
				System.out.print("You didn't enter a number, try again: ");
			}
		}
		
		correctInput = false;
		
		System.out.print("Enter rate: ");
		
		
		while(!correctInput) {
			if(console.hasNextInt()) {
				r = console.nextInt();
				correctInput = true;
			} else {
				console.nextLine();
				console.nextLine();
				System.out.print("You didn't enter a number, try again: ");
			}
		}
		
		correctInput = false; 
		
		System.out.print("Enter time in years: ");
		
		while(!correctInput) {
			if(console.hasNextInt()) {
				t = console.nextInt();
				correctInput = true;
			} else {
				console.nextLine();
				console.nextLine();
				System.out.print("You didn't enter a number, try again: ");
			}
		}
		System.out.println("Your total iterest after " + t + " years is $" + (r*t*p));
	}
}
