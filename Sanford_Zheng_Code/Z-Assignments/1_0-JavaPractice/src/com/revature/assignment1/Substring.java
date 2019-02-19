package com.revature.assignment1;

/**
 * Question 5
 * 
 * @author Sanford
 *
 */

public class Substring {
	
	private String s;
	
	public Substring() {
		
	}

	public Substring(String s) {
		this.s = s;
	}
	
	public Substring(String s, int start, int end) {
		this.s = inclusiveSubstring(s, start, end);
	}
	
	public static String inclusiveSubstring(String s, int start, int end) {
		start = ( start < 0 ) ? 0 : start;
		end = ( end > s.length()-1 ) ? s.length()-1 : end;
		if( end-start+1 > s.length() || end-start+1 < 0 ) return s;
		
		char[] c = s.toCharArray();
		char[] res = new char[end-start+1];
		
		for(int i = 0; i <= end - start; i++) {
			res[i] = c[i+start];
		}
		
		return String.valueOf(res);
	
	}
	
	
	
	@Override
	public String toString() {
		return s;
	}
	
}
