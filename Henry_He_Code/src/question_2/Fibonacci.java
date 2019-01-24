package question_2;

public class Fibonacci {
	
	/*
	 * Admittedly, it's a rather unconventional way for me to write fibonacci print...
	 * but I like it for its space efficiency. You really just need the previous two terms
	 * to calculate the next term.
	 */
	
	static void fibPrint() {
		int[] fibArray = {0,1};
		System.out.println(fibArray[0]);
		System.out.println(fibArray[1]);
		int count = 2;
		while(count < 25) {
			fibArray[ count % 2 ] += fibArray[ (count - 1) % 2 ];
			System.out.println( fibArray[count % 2] );
			count++;
		}
	}
	
	public static void main(String[] args) {
		fibPrint();
	}
	
}
