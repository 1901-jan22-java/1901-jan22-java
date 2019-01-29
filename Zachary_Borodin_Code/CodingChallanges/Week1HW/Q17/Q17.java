package com.revature.hw1.Q17;

import java.util.Scanner;

public class Q17 {
	public static void main(String[] args) {
		System.out.println("Lets find the Interest");
		System.out.print("Enter the Principle:");
		double principle = 0.0;
		double rate = 0.0;// in percentage
		double time= 0.0; //in years
		Scanner scan = new Scanner(System.in);
		String prin= scan.nextLine();
		try {
			double p= Double.parseDouble(prin);
			principle = p;
		}catch(NumberFormatException e) {
			System.out.println("Invalid input for principle. Enter a number");
		}
		
		System.out.print("Enter the Rate(in percentage):");
		Scanner scan2 = new Scanner(System.in);
		String r= scan.nextLine();
		try {
			double x= Double.parseDouble(r);
			rate = x;
		}catch(NumberFormatException e) {
			System.out.println("Invalid input for rate. Enter a number");
		}
		
		System.out.print("Enter the Time(in years):");
		Scanner scan3 = new Scanner(System.in);
		String t= scan.nextLine();
		try {
			double y= Double.parseDouble(t);
			time = y;
		}catch(NumberFormatException e) {
			System.out.println("Invalid input for rate. Enter a number");
		}
		
		System.out.println("The Interest is: ");
		System.out.println(principle*rate*time);
	}

}
