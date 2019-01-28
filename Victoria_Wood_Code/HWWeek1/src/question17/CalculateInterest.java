package question17;

import java.util.Scanner;

public class CalculateInterest {
	public static void main(String[] args) {
		System.out.println("Calculate Interest");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What is your principal amount?");
		int principal = scan.nextInt();
		
		System.out.println("What is your rate of interest?");
		float rate = scan.nextFloat();
		
		System.out.println("How many years of interest have you accrued?");
		int time = scan.nextInt();
		
		System.out.println("Your total interest is: " + principal*rate*time);
	}

}
