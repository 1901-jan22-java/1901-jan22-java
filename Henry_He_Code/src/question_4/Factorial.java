package question_4;

public class Factorial {

	// Let's keep this short and simple with recursion...
	static int calculate_factorial(int n) {
		if(n == 0) return 1;
		return n * calculate_factorial(n-1);
	}
	
	public static void main(String[] args) {
		System.out.print(calculate_factorial(10));
	}
	
}
