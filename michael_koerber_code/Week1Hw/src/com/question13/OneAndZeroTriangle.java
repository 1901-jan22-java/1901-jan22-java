package com.question13;

public class OneAndZeroTriangle {

	public static void main(String[] args) {
		for(int i=1;i<=4;i++){ // set to four because thats the base of the triangle.  
			System.out.println(); // Prints out initial blank line and a blank line every time the for loop runs.
			for(int j=1;j<=i;j++){ // the amount of times the inner loop runs will increase with the value of i.
				System.out.print(((i+j)%2)+" "); // checks for a remainder of the sum of i + j.
			} // Works out so that every other increment will give 0 remainder or a remainder or 1, continuing the 0101 sequence
			System.out.print("\n"); // escapes the current sequence
		}
	}
}
