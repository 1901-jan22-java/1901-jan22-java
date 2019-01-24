package com.revature.manualsubstring;

public class ManualSubstring {
	public static String manSubstring(String str, int idx) {
		String result = "";
		while(idx >= 0) {
			result = str.charAt(idx) + result;
			idx--;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(manSubstring("eefuwiehfwhfuygsu", 10));
	}
}
