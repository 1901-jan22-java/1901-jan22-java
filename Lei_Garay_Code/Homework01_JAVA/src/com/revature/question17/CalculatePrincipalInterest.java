package com.revature.question17;

import java.util.Scanner;

public class CalculatePrincipalInterest {
	static void calculateSimpleInterest()
	{
		double interest;
		double rate;
		double time;
		double principal;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter principal ($):");
		principal = Double.parseDouble(sc.nextLine().replaceAll("[^\\d.]", ""));
		System.out.println("Enter rate:");
		rate = Double.parseDouble(sc.nextLine());
		System.out.println("Enter time (in years):");
		time = Double.parseDouble(sc.nextLine());
		
		interest = principal * rate * time;
		
		System.out.println("Principal is $ "+interest);
	}
	
	public static void main(String[] args) {
		calculateSimpleInterest();
	}
}
