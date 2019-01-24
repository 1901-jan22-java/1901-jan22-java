
public class Fibonacci {
	public static int nextFib(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 1;
		int fib;
		for(int i=1; i < 25; i++) {
			fib = nextFib(num1, num2);
			num1 = num2;
			num2 = fib;
			if(i == 1) {
				System.out.print(0 + ", " + num2 + ", ");
			} else if(i == 25) {
				System.out.print(fib);
			}
			
			System.out.print(fib + ", ");
			
		}
	}
}
