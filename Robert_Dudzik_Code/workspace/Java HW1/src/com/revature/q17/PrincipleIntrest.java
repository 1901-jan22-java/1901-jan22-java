package com.revature.q17;

import java.util.Scanner;

public class PrincipleIntrest
{

	public static void main(String[] args)
	{
		System.out.println("Please enter the principle: ");
		Scanner scan = new Scanner(System.in);
		String principle = scan.nextLine();
		System.out.println("Please enter the rate: ");
		String rate = scan.nextLine();
		System.out.println("Please enter the number of years: ");
		String years = scan.nextLine();
		double interest = IntrestCalc(Double.valueOf(principle), Double.valueOf(rate), Integer.valueOf(years));
		System.out.println("Your Simple Intrest is: " + interest);
		
	}
	
	public static double IntrestCalc(double principle, double rate, int years)
	{
		return (double)(principle * rate * years);
	}
}
