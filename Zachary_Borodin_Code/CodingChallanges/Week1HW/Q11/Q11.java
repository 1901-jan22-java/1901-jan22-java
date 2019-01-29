package com.revature.hw1.Q11;

import com.revature.hw1.Q11AnotherPK.Q11AnotherPK;

public class Q11 {
	
	public static void main(String[] args) {
		
		System.out.println("Need to import the other package we plan to get the variables from");
		Q11AnotherPK test = new Q11AnotherPK();
		System.out.println("If the variables were public you can access them directly");
		System.out.println(test.f1);
		System.out.println(test.f2);
		
		System.out.println("If the variables are prive you need to use methods to access them");
		System.out.println(test.getF3());
		System.out.println(test.getF4());
	}
	

}
