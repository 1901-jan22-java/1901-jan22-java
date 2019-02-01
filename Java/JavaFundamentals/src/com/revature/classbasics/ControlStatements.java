package com.revature.classbasics;

/**
 * 
 * @author Sanford Zheng
 *
 * Control statements affect the flow of your application. This includes loop , ifs, whiles , switch, etc.
 * Outside of these code structures, it is important to knowthe keywords continues, break, and understand labels for blocks of code.
 */

public class ControlStatements {
	
	public static void main(String[] args) {
		
		// FOR LOOPS: 
		for(int i = 0; i < args.length; i++)
			System.out.println(args[i]);
		
		// FOR-EACH LOOP AKA ENHANCED FOR LOOP: Executes repeatedly for all items in the object
		for(String s: args)
			System.out.println(s);
		
		// WHILE: Executes repeatedly so long as the while condition is true
		int num = 1;
		while(num > 1) {
			System.out.println("something is true");
		}
		
		// DO-WHILE: Executes at least once and continues repeatedly if while condition is true
		do { System.out.println("doing things"); }while(num > 1);
		
		// IF: Checks condition and executes if true
		if(num == 1) {
			System.out.println("num is 1");
		} else if(num == 5) {
			System.out.println("num is 5");
		} else {
			System.out.println("oops!");
		}
		
		/* SWITCH: Can only be used for Strings, enums and
		* 	values that can be casted up to int. 
		*	(primitives and their respective wrappers.)
		*/
		switch(num) {
		case 1: System.out.println("1"); break;
		case 5: System.out.println("5"); break;
		default: System.out.println("default");
		}
		
	}
}
