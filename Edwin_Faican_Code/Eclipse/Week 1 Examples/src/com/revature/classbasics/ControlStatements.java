package com.revature.classbasics;


public class ControlStatements {
	/*
	 * Control statements affect the flow of your application.
	 * This includes loops, if, whiles, switch, etc...
	 * Outside of these code structures, it is important to know the 
	 * keywords: Continue, Break, and understand the labels for blocks of code. 
	 */
	
	public static void main(String[] args) {
		//FOR LOOP
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		
		//UNCONVENTIONAL FOR LOOPS
		int num = 1;
		for(; ; ) {
			num += 2;
			if(num == args.length) break; 
		}
		
		//FOR EACH LOOP
		for(String s : args) {
			System.out.println(s);
		}
		
		//WHILE 
		while(num > 1) {
			System.out.println("This works.");
		}
		
		//DO-WHILE
		do {
			System.out.println("This also works.");
		} while(num > 1);
		
		//IF STATEMENTS
		if(num == 1) {
			System.out.println("num is 1");
		}else if(num == 5) {
			System.out.println("num is 5");
		} else {
			System.out.println("oops I did it again! I messed with your num!");
		}
		
		//SWITCH STATEMENTS - Only for Strings, enums and values that can be cast to int
		switch(num) {
			case 1: System.out.println("num is 1"); break;
			case 5: System.out.println("num is 5"); break;
			default: System.out.println("num is neither!");
		}
		
		/* 
		 * Break will exit the loop or block while
		 * Continue will move on to next iteration of block. 
		 */
	}
}
