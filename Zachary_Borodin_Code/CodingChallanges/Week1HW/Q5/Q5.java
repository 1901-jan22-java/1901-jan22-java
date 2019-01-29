//Zachary Borodin
package com.revature.hw1.Q5;
//substring method
import java.util.Scanner;

public class Q5 {
	public static String subString(String s, int index) {
		//test if index is valid
		if(index > s.length()) {
			//index is larger then the size of the string
			System.out.println("String is smaller then "+ index);
			return "Invalid Index";
		}
		else if(index < 0){
			System.out.println("Can't have a negative index");
			return "Invalid Index";
		}
		else {
			//convert string to char array and form a string from what is needed
			char c[] = s.toCharArray();
			String result = "";
			for(int i=0; i<=index;i++) {
				result += c[i];
			}
			return result;
		}
		
	}
	
	public static void main(String[] args) {
		//user input to get the String
		System.out.println("Enter a String: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		//user input to get the index
		System.out.println("Enter an index:(zero is the first position) ");
		Scanner scan2 = new Scanner(System.in);
		String index = scan2.nextLine();
		int i = Integer.parseInt(index);
		
		String answer = subString(s,i);
		System.out.println(answer);
	}
}
