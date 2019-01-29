package com.revature.classbasics;

public class ControlStatements {
	/*
	 * control statements affect the flow of your application. 
	 * This includes loops, ifs, whiles, switch, etc.
	 * Outside of these code structures, it is important to know the keywords
	 * continue, break, and understand labels for blocks of code.
	 */

	
	public static void main(String[] args) {
		//FOR LOOP
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
		int num = 1;
		//initalized var; bounds for loop; var val
		for (; ;) {
			num += 2;
			if (num == args.length) break;
		}
		
		//FOR-EACH AKA ENHANCED FOR LOOP
		for (String str: args) {
			System.out.println(str);
		}
		
		// WHILE
		while (num > 1) {
			System.out.println("this works"); // will never execute - only happens when certain condition is met
		}
		
		//DO-WHILE
		do {
			System.out.println("some stuff"); // will execute at least once
		} while(num > 1);
		
		//IF - checks condition - u know
		
		//SWITCH
		/* 
		 * can only be used for strings, enums, and values that can be
		 * cast up to int
		 * int, short, byte, char (and their respective wrapper classes)
		 */
		switch (num) {
		case 1: System.out.println(1); break;
		case 5: System.out.println(5); break;
		case 10: System.out.println(10); break;
		default: System.out.println(" idk what number this is");
		}
		
		
		/*
		 * BREAK v CONTINUE
		 * break will exit the loop or block of code
		 * continue will move on to the next iteration of the loop
		 */
		
	}
	
}
