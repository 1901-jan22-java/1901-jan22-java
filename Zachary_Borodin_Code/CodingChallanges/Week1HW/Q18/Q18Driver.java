package com.revature.hw1.Q18;

public class Q18Driver {

	public static void main(String[] args) {
		Q18 test = new Q18();
		boolean oneT = test.checkUppercase("Hello");
		System.out.println(oneT);
		boolean oneF = test.checkUppercase("tree");
		System.out.println(oneF);
		
		String two = test.turnUppercase("blue");
		System.out.println(two);
		
		test.toInt("20");
		
	}
}
