package com.question2;

public class Fib {

	public static void main(String[] args) {
		int n = 25; // Return only the first 25 fib numbers
		int t1 = 0; 
		int t2 = 1; // Fib sequence is the sum of sequential numbers.
        
        for (int i = 1; i <= n; i++){
            System.out.print(t1 + ", ");// Printing out t1 which will be the sum of the previous numbers in the sequence.
            int sum = t1 + t2; // Set the sum variable to the sum of the numbers in the sequence.
            t1 = t2; // Move the larger number(summed number) into the place of t1
            t2 = sum; // t2 now equals the new sum.
        }

	}

}
