package com.revature.hw1.Q21;

public class Q21 {

	public static void main(String[] args) {
		String s = "tree";
		StringBuilder sb = new StringBuilder(s);
		for(int i=0; i<sb.length();i++) {
			char test = sb.charAt(i);
			for(int j=i+1; j<sb.length();j++) {
				char equalTest = sb.charAt(j);
				if(test == equalTest)
					sb.deleteCharAt(j);
			}
		}
		
		System.out.println(sb);
	}
}
