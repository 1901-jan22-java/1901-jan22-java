package question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

public class MyClass {
	public static void main(String[] args) {
		int choice; // declare variable
		Scanner s = new Scanner(System.in); //create scanner
		System.out.println(
				"Enter your choice:\n1)Find the square root of number\n2)Display today's date\n3)Split the string and store in array\n");
		choice = s.nextInt(); //takes whatever int is entered in the console
		switch (choice) {
		case 1:
			System.out.println("Enter the number\n");
			int n = s.nextInt();
			double squareRoot = Math.sqrt(n);
			System.out.println("Square root of " + n + " is " + squareRoot);
			break;
		case 2:
			LocalDateTime date = LocalDateTime.now();
			System.out.println(date.toString());
			break;
		case 3:
			String st = "I am learning Core Java";
			String[] stArray = st.split(" "); //spaces the string at each space
			for (int i = 0; i < stArray.length; i++) {
				System.out.println(stArray[i]);
			}

		}
	}
}


