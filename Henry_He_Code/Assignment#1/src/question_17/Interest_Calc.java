package question_17;

import java.util.Scanner;

public class Interest_Calc {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Welcome to the interest rate calculator. "
				+ "\nPlease enter entering your principal amount, rate, then time."
				+ "\nDo separate each input value with a semicolon!\n"
				);
		String[] data = scan.nextLine().split(":");
		
		Double result = Double.parseDouble(data[0]) * Double.parseDouble(data[1]) * Double.parseDouble(data[2]);
		System.out.println("Your interest is: " + result + "\nThank you for your patronage!");
	}
	
}
