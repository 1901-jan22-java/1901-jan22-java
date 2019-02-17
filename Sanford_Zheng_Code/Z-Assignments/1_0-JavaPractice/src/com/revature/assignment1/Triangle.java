package com.revature.assignment1;

/**
 * Question 13
 * 
 * @author Sanford
 *
 */

public class Triangle {
	public static void main(String[] args) {
		System.out.println(binary(100));
	}
	
	public static String binary(int depth) {
		StringBuilder res = new StringBuilder();
		boolean bit = false;
		
		for(int i = 1; i < depth+1; i++) {
			for(int j = 0; j < i; j++) {
				res.append(bit ? 1 : 0);
				bit  = !bit;
				if(j != i-1) res.append(" ");
			}
			if(i != depth) res.append("\n");
		}
		
		return res.toString();
	}
	
}
