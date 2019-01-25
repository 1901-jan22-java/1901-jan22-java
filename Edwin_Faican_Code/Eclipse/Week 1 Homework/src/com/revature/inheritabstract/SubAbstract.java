package com.revature.inheritabstract;

import java.util.Scanner;

public class SubAbstract extends SuperAbstract{

	@Override
	public boolean hasUpperCase(String s) {
		for(int i=0; i < s.length()-1; i++) {
			if(s.charAt(i) >= 97) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String lowerToUpper(String s) {
		for(int i=0; i < s.length()-1; i++) {
			if(this.hasUpperCase(s.substring(i,i+1))) {
				s = s.substring(0, i) + s.substring(i,i+1).toUpperCase() + s.substring(i+1);
			}
		}
		return s;
	}

	@Override
	public int addTen(String s) {
		Scanner checkNum = new Scanner(s);
		if(!checkNum.hasNextInt()) {
			System.out.println("Sorry, your String is not entirely a number.");
		} else {
			return Integer.parseInt(s) + 10;
		}
		return -1;
	}
	
}
