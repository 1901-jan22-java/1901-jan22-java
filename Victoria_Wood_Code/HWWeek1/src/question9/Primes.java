package question9;

import java.util.ArrayList;

public class Primes {
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i <= 100; i++) {
			numbers.add(i);
			}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int n : numbers) {
			if(isPrime(n)) {
				primes.add(n);
				}
			}
		
		System.out.println(numbers);
		System.out.println(primes);
	}
	
	public static boolean isPrime(int n) {
		for(int i = 2; i < n; i++) { //starting i at two since all prime numbers are divisible by 1
			if(n%i == 0) return false; // with each loop check to see if n is equally divisible by i 
										//checking each number up until n
		}	
		return true;
	}

}
