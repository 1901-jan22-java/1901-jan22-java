package com.revature.utilities;

import java.util.Arrays;

public interface Printable {
	
	default void printArray(int[]array) {
		System.out.println(Arrays.toString(array));
	}
}
