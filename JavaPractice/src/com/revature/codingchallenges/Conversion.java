package com.revature.codingchallenges;

import java.util.Stack;

public class Conversion {
	public static void main(String[] args) {
		Conversion con = new Conversion();
		
		System.out.println(con.decimalToHex(90415129));
	}
	
	public String decimalToHex(long a) {
		Stack<String> build = new Stack<>();
		while(a>0) {
			long rem = a%16;
			if(rem > 9) {
				rem += 'a'-10;
				build.add(Character.toString((char)rem));
			}else build.add(Long.toString(rem));
			a /= 16;
		}

		StringBuilder res = new StringBuilder("0x");
		while(!build.isEmpty()) {
			res.append(build.pop());
		}
		
		return res.toString();
	}
}
