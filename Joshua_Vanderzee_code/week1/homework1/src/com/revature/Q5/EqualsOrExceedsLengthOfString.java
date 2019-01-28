package com.revature.Q5;

public class EqualsOrExceedsLengthOfString extends Throwable {
	public EqualsOrExceedsLengthOfString(String substring) {
		super("Was provided an ending index that Equals or exceeds " + substring + ". ");
	}
}
