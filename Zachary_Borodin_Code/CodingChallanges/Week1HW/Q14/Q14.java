//Zachary Borodin
package com.revature.hw1.Q14;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//switch case example
public class Q14 {

	public static void main(String[] args) {
		System.out.println("Switch case example");
		System.out.println("1. Find Square root of a number");
		System.out.println("2. Disply Today's date");
		System.out.println("3. Split the string");
		System.out.println("Enter 1,2,or 3:");
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		int value = Integer.parseInt(in);
		switch(value) {
		case 1:{
			System.out.println("Enter a number to find its square root");
			Scanner scan2 = new Scanner(System.in);
			String num = scan.nextLine();
			try{double number = Double.parseDouble(num);
			System.out.println("The square root of "+ num + " is "+Math.sqrt(number));

			}catch(NumberFormatException e) {
				System.out.println("Input not a number. Try again");
			}
			
			
		}break;
		case 2:{
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			System.out.println("Todays date is " + df.format(date));
		}break;
		
		case 3:{
			String s= "I am learning Core Java";
			String split[] = s.split(" ");
			System.out.println("The split string is: ");
			for(int i=0; i<split.length;i++) {
				System.out.println(split[i]);
			}
			
		}break;
		default:
			System.out.println("Invalid number entered. Enter 1,2,or 3");
			break;
	}
}
}
