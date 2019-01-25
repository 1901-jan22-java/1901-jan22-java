package com.revature.sillybinarytree;

public class SillyBinaryTree {
	public static void main(String[] args) {
		String line = "0";
		boolean left = true;
		boolean zero = false;
		for(int i=0; i <= 50; i++ ) {
			System.out.println(line);
			if(left) {
				if(zero) {
					line = "0 " + line;
				} else {
					line = "1 " + line;
				}
				left = false;
			} else {
				if(zero) {
					line = line + " 0";
					zero = false;
				} else {
					line = line + " 1";
					zero = true;
				}
				left = true;
			}
		}
		
	}
}
