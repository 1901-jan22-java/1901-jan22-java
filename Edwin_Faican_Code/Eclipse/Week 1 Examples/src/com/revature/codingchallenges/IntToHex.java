package com.revature.codingchallenges;

public class IntToHex {
	public static String convertToHex(int n) {
		
		String hex = "";
		while(n != 0) {
			//If the mod is less than 10, the 'decimal' representation can be used.
			if(n%16 < 10) {
				hex = n%16 + hex;
			} else {
				//If the modulus is greater than 9, we consider the cases from 10 to 15. 
				switch(n%16) {
					case 10: hex = "a" +  hex; break;
					case 11: hex = "b" +  hex; break;
					case 12: hex = "c" +  hex; break;
					case 13: hex = "d" +  hex; break;
					case 14: hex = "e" +  hex; break;
					case 15: hex = "f" +  hex; break;
					default: break; // We don't need to consider any other options. 
				}
			}
			n/= 16;	
		}
		System.out.println(hex);
		return hex;
	}
	public static void main(String[] args) {
		convertToHex(46);
	}
}
