//Zachary Borodin

package com.revature.hw1.Q6;
//determine if an integer is even with using %
import java.util.Scanner;

public class Q6 {

	public static boolean isEven(int i) {
		boolean answer;
		if(i/2 == (i+1)/2) {
			System.out.println("The integer is even.");
				answer = true;
		}
		else {
			System.out.println("The integer is NOT even.");
			answer = false;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter an integer to find if it's even: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		int n = 0;
		boolean NumberInput = true;
		
		//checks to see if the user input is a number
		try{
			 n = Integer.parseInt(name);
		}catch(NumberFormatException e) {
			//user input is not a number
			System.out.println(name +" is not an integer. Try again");
			NumberInput = false;
		}
		if(NumberInput == true) {
			//user input is a number
			boolean answer = isEven(n);
		
		}
	}
}
