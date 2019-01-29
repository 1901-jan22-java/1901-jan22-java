package com.revature.hw1.Q24;
//turn an int into hexidecimal
import java.util.Scanner;

public class Q24 {
		
		public static String convert(int num) {
			String result = "";
			while (num >0) {
				int x = num%16;
				//System.out.println(x);
				switch(x) {
					case 10: result = "A"+result; break;
					case 11: result = "B"+result; break;
					case 12: result = "C"+result; break;
					case 13:result = "D"+ result; break;
					case 14:result = "E"+result; break;
					case 15:result = "F"+result; break;
					default: result= Integer.toString(x) + result; 
				}
				num /=16;
				//System.out.println(num);

			}
			
			return result;

		}
		
		public static boolean anagram(String a, String b) {
			if(!(a.length() == b.length())){
				System.out.println("String are not equal length");
				return false;
			}
			while(!a.isEmpty()) {
				char c = a.charAt(0);
			}
			return true;
			
		}
		public static void main(String[] args) {
			System.out.println("Enter an integer to find its Hexadecimal format: ");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			int n = 0;
			boolean NumberInput = true;
			
			//checks to see if the user input is an integer
			try{
				 n = Integer.parseInt(name);
			}catch(NumberFormatException e) {
				//user input is not an integer
				System.out.println(name +" is not an integer. Try again");
				NumberInput = false;
			}
			if(NumberInput == true) {
				//user input is an integer
				String answer = convert(n);
				System.out.println(answer);
		}
	}
}
