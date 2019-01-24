package com.revature.codingchallenges;

public class IntToHex {

	public static void convert(int num){
		StringBuilder str = new StringBuilder("");
		char[] hex = {'a','b','c','d','e','f'};
		while(num > 0){
			int remainder = num % 16;
			System.out.println(remainder);
			if(remainder>9){
				str.append(hex[remainder-10]);
			} else str.append(remainder);
			num /= 16;
			System.out.println(str);
		}
		System.out.println(str.reverse());
	}
	
	public static void main(String[] args) {
		convert(1023);
	}
}


