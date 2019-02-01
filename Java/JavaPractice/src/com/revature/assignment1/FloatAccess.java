package com.revature.assignment1;

import org.omg.CORBA.FloatHolder;

//import com.revature.assignment.floatholder.FloatHolder;

/**
 * Question 11
 * 
 * @author Sanford
 *
 */

public class FloatAccess {
	public static void main(String[] args) {
		FloatHolder fh1 = new FloatHolder(1.1f);
		FloatHolder fh2 = new FloatHolder(2.3f);
		
//		FloatHolder fh = new FloatHolder(1.1f, 2.3f);
		
		System.out.println("Float #1: " + fh1.value + "\nFloat #2: " + fh2.value);
	}
}
