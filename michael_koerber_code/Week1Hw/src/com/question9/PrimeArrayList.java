package com.question9;

import java.util.ArrayList;

public class PrimeArrayList {	
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(100); //Create numbers Array

		for (int i = 1; i <= 100; i++){
		   numbers.add(i); // Add 1 - 100 to the array
		}
		
		for(int i = 2; i < numbers.size(); i++){ //Since 1 is not prime we start at 2, calling the checkPrime method for each number until 100
			if(checkPrime(i) == true){
				System.out.println(i); // Printing those prime numbers who return true to the console
			}
		}
	}
	
	public static boolean checkPrime(int numberToCheck) {
        int remainder; // Using the sqrt of the number is more efficient than looping from 2 until the number itself, gives same result
        for (int i = 2; i <= Math.sqrt(numberToCheck); i++) { // A prime number is any number which cannot be divided evenly by any number other than 1 and itself.
            remainder = numberToCheck % i; // Using modulus operator to check for a remainder, indicating a number is evenly divisible by i
            if (remainder == 0) {
                return false;
            }
        }
        return true;
    }
}
