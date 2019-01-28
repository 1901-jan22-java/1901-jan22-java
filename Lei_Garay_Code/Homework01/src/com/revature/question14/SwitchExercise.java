package com.revature.question14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class SwitchExercise {
	static void switchDemo()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number 1-3 to implement case:");
		int num = sc.nextInt();
		
		switch(num)
		{
		case 1: System.out.println("Enter number to Square Root:");
				int input = sc.nextInt();
				System.out.println(Math.sqrt((double)input)); break;
			
		case 2: DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/DD/YYYY");
				LocalDate localDate = LocalDate.now();
				System.out.println(dtf.format(localDate)); break;
			
		case 3: String toBeSplit = "I am learning Core Java";
				String [] words = toBeSplit.split("\\s+");
				System.out.println(Arrays.asList(words)); break;
		}
	}
	
	public static void main(String[] args) {
		switchDemo();
	}
}
