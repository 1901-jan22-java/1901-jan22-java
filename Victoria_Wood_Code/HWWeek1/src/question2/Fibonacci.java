package question2;

public class Fibonacci {
	
	static int MAX = 23; // max number set to 23 since beginning at second fib number
	
	// only way it works - still not fully sure why - changing starting value of i doesn't work
	
	public static void main(String[] args) {
		System.out.println(fib());
		
	}
	
	public static String fib() {
		String fibSeq = "0, "; //including first fibonacci number in string to begin
		int x = 0; // intializing two integers to hold first two numbers of fib sequence
		int y = 1; 
		for (int i = 0; i < MAX ; i++) {
			int z = x + y; //next number in sequence
			if (i == 22) {
				fibSeq = fibSeq + z; // so last number doesn't have comma afterwards
			} else {
			fibSeq = fibSeq + z + ", "; // add newest fib number to end of string
			}
			x = y; // reassign x and y to hold next two numbers to be added in fib sequence
			y = z;
		}
		return fibSeq; //return string of first 25 numbers of fibonacci sequence
	}

}
