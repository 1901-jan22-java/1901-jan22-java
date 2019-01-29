package com.revature.hw1.Q10;
//finding the minimim of two numbers ising ternary opertors
import java.util.Scanner;

public class Q10 {
	public static void min(double a, double b) {
		double result = (a<b? a:b);
		System.out.println(result + " is the min");	
	}
	
	public static void main(String[] args) {
		System.out.println("Find the min of two numbers");
		System.out.println("Enter the first number: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		double n1 = 0.0;
		boolean NumberInput = true;
		
		//checks to see if the user input is an integer
		try{
			 n1 = Double.parseDouble(name);
		}catch(NumberFormatException e) {
			//user input is not an integer
			System.out.println(name +" is not a number. Try again");
			NumberInput = false;
		}
		
		System.out.println("Enter the second number: ");
		Scanner scan2 = new Scanner(System.in);
		String name2 = scan.nextLine();
		double n2 = 0;
		
		//checks to see if the user input is an integer
		try{
			 n2 = Double.parseDouble(name);
		}catch(NumberFormatException e) {
			//user input is not an integer
			System.out.println(name +" is not a number. Try again");
			NumberInput = false;
		}
		if(NumberInput == true) {
			//user input is an integer
			min(n1,n2);

		}
	}
}
