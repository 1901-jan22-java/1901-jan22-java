package com.revature.Q5;

public class SubstringClass {
	public static String Substring(String str, int idx) throws EqualsOrExceedsLengthOfString {
		if (idx >= str.length()) {
			throw new EqualsOrExceedsLengthOfString(str + " [idx: " + idx + "].");
		}
		if (idx - 1 == 0) return str.charAt(idx - 1) + "";
		return Substring(str, idx - 1) + str.charAt(idx - 1);
	}
}
