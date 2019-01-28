package com.revature.Q12;

import com.revature.Q6.EvenNumberClass;

public class EvenNumberPrint {
	public static void Print() {
		int[] numbers = new int[100];
		for (int i = 1; i <= 100; i++) {
			numbers[i - 1] = i;
		}
		
		for (int i : numbers) {
			if (EvenNumberClass.IfEven(i))
				System.out.println(i);
		}
	}
}
